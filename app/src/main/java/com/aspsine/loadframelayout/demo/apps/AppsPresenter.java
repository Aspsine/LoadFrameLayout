package com.aspsine.loadframelayout.demo.apps;


import android.content.Context;

import com.aspsine.loadframelayout.demo.data.App;
import com.aspsine.loadframelayout.demo.data.source.Callback;
import com.aspsine.loadframelayout.demo.data.source.local.AppsLoader;

import java.util.List;


/**
 * Created by aspsine on 16/4/8.
 */
public class AppsPresenter implements AppsContract.Presenter {

    private AppsContract.View mAppsView;


    public AppsPresenter(AppsContract.View appsView) {
        this.mAppsView = appsView;

        this.mAppsView.setPresenter(this);
    }

    @Override
    public void autoRefresh() {
        mAppsView.showLoadingView();
        AppsLoader.loadApps((Context) mAppsView, new Callback<List<App>>() {
            @Override
            public void onSuccess(List<App> apps) {
                if (apps == null || apps.isEmpty()){
                    mAppsView.showEmptyView();
                }else {
                    mAppsView.showApps(apps);
                    mAppsView.showContentView();
                }
            }

            @Override
            public void onFailure(Exception e) {
                e.printStackTrace();
                mAppsView.showEmptyView();
            }
        });
    }
}
