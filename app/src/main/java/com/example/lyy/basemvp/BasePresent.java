package com.example.lyy.basemvp;

/**
 * Created by LYY on 2017/12/18.
 */

public class BasePresent<V> {
    public V view;

    public void attach(V v) {

        this.view = v;
    }

    public void detach() {
        this.view = null;
    }
}
