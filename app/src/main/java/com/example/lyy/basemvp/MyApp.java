package com.example.lyy.basemvp;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

/**
 * Created by LYY on 2017/12/18.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).imageDownloader(
                new BaseImageDownloader(this, 60 * 1000, 60 * 1000)) // connectTimeout超时时间
                .build();
        ImageLoader.getInstance().init(config);
    }
}
