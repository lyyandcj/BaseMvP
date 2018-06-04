package com.example.lyy.basemvp.common;

import java.util.Map;
import java.util.Observer;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by LYY on 2017/12/18.
 */

public interface APIService {

    //http://m.yunifang.com/yunifang/mobile/home
    @GET
    Observable<String> get(@Url String url, @QueryMap Map<String, String> map);

    @GET
    Observable<String> get(@Url String url);

    @FormUrlEncoded
    @POST
    Observable<String> post(@Url String url, @FieldMap Map<String, String> map);

}
