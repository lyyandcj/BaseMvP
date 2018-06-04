package com.example.lyy.basemvp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lyy.basemvp.present.MainPresent;
import com.example.lyy.basemvp.view.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainView, MainPresent> implements MainView {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    private MyAdapter myAdapter;

    @Override
    public MainPresent initPresenter() {
        return new MainPresent();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter.getData();
//找到布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearLayoutManager);
        //
        myAdapter = new MyAdapter(this);
        recycler.setAdapter(myAdapter);
    }

    @Override
    public void Onsuccess(Bean bean) {
        myAdapter.addData(bean);
    }
}
