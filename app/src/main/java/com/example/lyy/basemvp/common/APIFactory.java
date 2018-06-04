package com.example.lyy.basemvp.common;

import java.util.Map;
import java.util.Observable;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by LYY on 2017/12/18.
 */

public class APIFactory {


    private APIFactory() {
    }

    private static APIFactory factory = null;

    public static APIFactory getInstance() {
        synchronized (APIFactory.class) {
            synchronized (APIFactory.class) {
                if (factory == null) {
                    factory = new APIFactory();
                }
            }
        }
        return factory;
    }

    public void get(String url, Map<String, String> map, Observer<String> observer) {
        RetrofitUtils.getInstance().get(url, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void get(String url, Observer<String> observer) {
        RetrofitUtils.getInstance().get(url)
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void post(String url, Map<String, String> map, Observer<String> observer) {
        RetrofitUtils.getInstance().post(url, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
