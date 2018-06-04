package com.example.lyy.basemvp.model;

import com.example.lyy.basemvp.Bean;
import com.example.lyy.basemvp.common.APIFactory;
import com.example.lyy.basemvp.common.AbstractObserver;

import java.util.HashMap;

/**
 * Created by LYY on 2017/12/18.
 */

public class MainModel {


    public void getData(final MainModelCallBack callBack) {

//创建一个map
        HashMap<String, String> map = new HashMap<>();

        APIFactory.getInstance().get("yunifang/mobile/home", new AbstractObserver<Bean>() {
            @Override
            public void onSuccess(Bean bean) {
                callBack.onSuccess(bean);
            }

            @Override
            public void onFailure(int code) {

            }
        });

    }
}
