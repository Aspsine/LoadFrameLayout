package com.aspsine.loadframelayout.demo.data.source.local;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;

import com.aspsine.loadframelayout.demo.data.App;
import com.aspsine.loadframelayout.demo.data.source.Callback;
import com.aspsine.loadframelayout.demo.data.source.ExecutorManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by aspsine on 16/4/8.
 */
public class AppsLoader {

    static Handler sHandler = new Handler(Looper.getMainLooper());

    public static void loadApps(Context context, Callback<List<App>> callback) {
        Context applicationContext = context.getApplicationContext();
        ExecutorManager.execute(new LoadAppsTask(applicationContext.getPackageManager(), callback));
    }

    static class LoadAppsTask implements Runnable {

        PackageManager mPackageManager;

        Callback<List<App>> mCallback;

        public LoadAppsTask(PackageManager pm, Callback<List<App>> callback) {
            this.mPackageManager = pm;
            this.mCallback = callback;
        }

        @Override
        public void run() {
            List<ApplicationInfo> applicationInfos = mPackageManager.getInstalledApplications(PackageManager.GET_META_DATA);
            if (applicationInfos == null) {
                applicationInfos = new ArrayList<>();
            }

            final List<App> apps = new ArrayList<>();

            for (ApplicationInfo applicationInfo : applicationInfos) {

                File apk = new File(applicationInfo.sourceDir);
                boolean mounted = apk.exists();
                Drawable icon = null;
                String name = null;
                if (mounted) {
                    icon = applicationInfo.loadIcon(mPackageManager);
                    name = applicationInfo.packageName;
                }
                App app = new App(name, icon);
                apps.add(app);
            }

            deliverToMainThread(new Runnable() {
                @Override
                public void run() {
                    mCallback.onSuccess(apps);
                }
            });

        }
    }

    static void deliverToMainThread(Runnable runnable) {
        sHandler.post(runnable);
    }


}
