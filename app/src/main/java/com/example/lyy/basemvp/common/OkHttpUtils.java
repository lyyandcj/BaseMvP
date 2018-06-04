package com.example.lyy.basemvp.common;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by LYY on 2017/12/18.
 */

public class OkHttpUtils {
    private static OkHttpClient client = null;

    public static OkHttpClient getInstance() {
        if (client == null) {

            client = new OkHttpClient.Builder()
                    .connectTimeout(2000, TimeUnit.SECONDS)
                    .writeTimeout(2000, TimeUnit.SECONDS)
                    .readTimeout(2000, TimeUnit.SECONDS)
                    .addInterceptor(new CommonHeaderInterceptor())
                    .addInterceptor(new LoggingInterceptor())
                    .build();
        }
        return client;
    }
}
