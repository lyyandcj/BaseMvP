package com.example.lyy.basemvp.present;

import com.example.lyy.basemvp.BasePresent;
import com.example.lyy.basemvp.Bean;
import com.example.lyy.basemvp.model.MainModel;
import com.example.lyy.basemvp.model.MainModelCallBack;
import com.example.lyy.basemvp.view.MainView;

/**
 * Created by LYY on 2017/12/18.
 */

public class MainPresent extends BasePresent<MainView> {

    public MainModel mmodel;

    public MainPresent() {
        this.mmodel = new MainModel();
    }

    public void getData() {

        mmodel.getData(new MainModelCallBack() {
            @Override
            public void onSuccess(Bean bean) {
                view.Onsuccess(bean);
            }
        });

    }
}
