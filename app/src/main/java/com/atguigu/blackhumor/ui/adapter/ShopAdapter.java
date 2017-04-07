package com.atguigu.blackhumor.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.service.entity.ShopBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 万里洋 on 2017/3/28.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.MyViewHolder> {
    private final Context mContext;
    private final List<ShopBean.ResultBean.RecordsBean> data;

    public ShopAdapter(Context mContext, List<ShopBean.ResultBean.RecordsBean> records) {
        this.mContext = mContext;
        this.data = records;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(mContext, View.inflate(mContext, R.layout.item_shop, null));
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.setData(data, position);
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_cover)
        ImageView ivCover;
        @Bind(R.id.tv_desc)
        TextView tvDesc;
        @Bind(R.id.play_count)
        TextView playCount;
        public MyViewHolder(Context mContext, View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener!=null){
                        mOnItemClickListener.onItemClick(v,getLayoutPosition());
                    }
                }
            });
        }
        public void setData(List<ShopBean.ResultBean.RecordsBean> data, int position) {
            ShopBean.ResultBean.RecordsBean recordsBean = data.get(position);
            tvDesc.setText(recordsBean.getTitle());
            playCount.setText(recordsBean.getSalvePrice()+"");
            Glide.with(mContext).load(recordsBean.getImgUrl()).into(ivCover);
        }
    }
    //定义接口
    public  interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , int position);
    }

    //创建字段有来接收接口实现类的实例
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    //set方法
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
