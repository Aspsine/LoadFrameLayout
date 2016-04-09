package com.aspsine.loadframelayout.demo.data.source;

/**
 * Created by aspsine on 16/4/8.
 */
public interface Callback<T> {

    void onSuccess(T t);

    void onFailure(Exception e);
}
