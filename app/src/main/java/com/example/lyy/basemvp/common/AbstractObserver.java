package com.example.lyy.basemvp.common;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by LYY on 2017/12/18.
 */

public abstract class AbstractObserver<T> implements Observer<String> {
    public abstract void onSuccess(T t);

    public abstract void onFailure(int code);

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(String s) {
        try {
            Type type =  getClass().getGenericSuperclass() ;
            Type [] types =  ((ParameterizedType)type).getActualTypeArguments() ;
            Class clazz = (Class) types[0] ;
            Gson gson = new Gson();
            T t = (T)  gson.fromJson(s,clazz);
            onSuccess(t);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            onFailure(2);
        }catch (Exception e){
            e.printStackTrace();
            onFailure(3);
        }
    }

    @Override
    public void onError(Throwable e) {
        onFailure(1);
        System.out.println(e
        );
    }

    @Override
    public void onComplete() {

    }
}
