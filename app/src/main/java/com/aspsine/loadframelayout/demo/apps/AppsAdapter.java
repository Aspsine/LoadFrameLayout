package com.aspsine.loadframelayout.demo.apps;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aspsine.loadframelayout.demo.R;
import com.aspsine.loadframelayout.demo.data.App;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 16/4/8.
 */
public class AppsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<App> mApps;

    public AppsAdapter() {
        this.mApps = new ArrayList<>();
    }

    public void setList(List<App> apps) {
        mApps.clear();
        mApps.addAll(apps);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        App app = mApps.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.title.setText(app.getName());
        viewHolder.image.setBackgroundDrawable(app.getIcon());
    }

    @Override
    public int getItemCount() {
        return mApps.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView)itemView.findViewById(R.id.title);
        }
    }
}
