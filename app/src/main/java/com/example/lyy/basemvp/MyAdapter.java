package com.example.lyy.basemvp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LYY on 2017/12/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<Bean.DataEntity.DefaultGoodsListEntity> list;

    public MyAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_layout, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textview.setText(list.get(position).goods_name);
        ImageLoader.getInstance().displayImage(list.get(position).goods_img, holder.imageview);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public void addData(Bean bean) {

        if (list == null) {

            list = new ArrayList<>();
        }
        list.addAll(bean.data.defaultGoodsList);
        notifyDataSetChanged();
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageview)
        ImageView imageview;
        @BindView(R.id.textview)
        TextView textview;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
