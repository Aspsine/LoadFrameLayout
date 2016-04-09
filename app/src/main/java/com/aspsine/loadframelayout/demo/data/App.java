package com.aspsine.loadframelayout.demo.data;

import android.graphics.drawable.Drawable;

/**
 * Created by aspsine on 16/4/8.
 */
public class App {
    String name;
    Drawable icon;

    public App() {
    }

    public App(String name, Drawable icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
