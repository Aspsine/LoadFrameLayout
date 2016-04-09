package com.aspsine.loadframelayout.demo.apps;

import com.aspsine.loadframelayout.demo.data.App;
import com.aspsine.loadframelayout.demo.base.BasePresenter;
import com.aspsine.loadframelayout.demo.base.BaseView;

import java.util.List;

/**
 * Created by aspsine on 16/4/8.
 */
public interface AppsContract {

    interface View extends BaseView<Presenter> {
        public void showLoadingView();

        public void showEmptyView();

        public void showErrorView();

        public void showContentView();

        public void showApps(List<App> apps);
    }

    interface Presenter extends BasePresenter {
        void autoRefresh();
    }
}
