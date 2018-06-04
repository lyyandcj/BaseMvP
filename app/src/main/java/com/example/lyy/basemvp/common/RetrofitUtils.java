package com.example.lyy.basemvp.common;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by LYY on 2017/12/18.
 */

public class RetrofitUtils {
    private static APIService service = null;

    public static APIService getInstance() {


        if (service == null) {
            synchronized (RetrofitUtils.class) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://m.yunifang.com/")
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(OkHttpUtils.getInstance())
                        .build();
                service = retrofit.create(APIService.class);
            }
        }
        return service;
    }
}
