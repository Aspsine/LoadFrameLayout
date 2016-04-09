package com.aspsine.loadframelayout.demo.apps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.aspsine.loadframelayout.LoadFrameLayout;
import com.aspsine.loadframelayout.demo.R;
import com.aspsine.loadframelayout.demo.data.App;

import java.util.List;

public class AppsActivity extends AppCompatActivity implements AppsContract.View {

    private AppsContract.Presenter mAppsPresenter;

    private AppsAdapter mAppsAdapter;

    private LoadFrameLayout loadFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAppsPresenter = new AppsPresenter(this);

        setContentView(R.layout.activity_apps);

        loadFrameLayout = (LoadFrameLayout) findViewById(R.id.loadFrameLayout);

        Button btnTryAgain = (Button) loadFrameLayout.findViewById(R.id.btnTryAgain);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        mAppsAdapter = new AppsAdapter();

        recyclerView.setAdapter(mAppsAdapter);

        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAppsPresenter.autoRefresh();
            }
        });

        mAppsPresenter.autoRefresh();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_control, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_content:
                showContentView();
                return true;
            case R.id.action_loading:
                showLoadingView();
                return true;
            case R.id.action_empty:
                showEmptyView();
                return true;
            case R.id.action_error:
                showErrorView();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setPresenter(AppsContract.Presenter presenter) {
        mAppsPresenter = presenter;
    }

    @Override
    public void showLoadingView() {
        loadFrameLayout.showLoadingView();
    }

    @Override
    public void showEmptyView() {
        loadFrameLayout.showEmptyView();
    }

    @Override
    public void showErrorView() {
        loadFrameLayout.showErrorView();
    }

    @Override
    public void showContentView() {
        loadFrameLayout.showContentView();
    }

    @Override
    public void showApps(List<App> apps) {
        mAppsAdapter.setList(apps);
    }
}
