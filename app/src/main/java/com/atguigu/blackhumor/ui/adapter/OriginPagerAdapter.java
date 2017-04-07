package com.atguigu.blackhumor.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.service.entity.RankBean;
import com.atguigu.blackhumor.utils.GlideRoundTransform;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 万里洋 on 2017/3/24.
 */

public class OriginPagerAdapter extends RecyclerView.Adapter<OriginPagerAdapter.MyViewHolder> {
    private final Context mContext;
    private final RankBean datas;
    private final List<RankBean.DataBean> data;

    public OriginPagerAdapter(Context mContext, RankBean rankBean) {
        this.mContext = mContext;
        this.datas = rankBean;
        data = rankBean.getData();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(mContext, R.layout.item_allstation, null);
        return new MyViewHolder(view);
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
            @Bind(R.id.tv_ranking)
            TextView tvRanking;
            @Bind(R.id.iv_allstation)
            ImageView ivAllstation;
            @Bind(R.id.tv_allstation)
            TextView tvAllstation;
            @Bind(R.id.tv_up_name)
            TextView tvUpName;
            @Bind(R.id.tv_grade)
            TextView tvGrade;
        public MyViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(itemView, getLayoutPosition());
                    }
                }
            });
        }

        public void setData(List<RankBean.DataBean> data, int position) {
            RankBean.DataBean dataBean = data.get(position);
            Glide.with(mContext).load(dataBean.getCover()).
                    transform(new GlideRoundTransform(mContext)).into(ivAllstation);
            tvRanking.setText(position+1+"");
            if (position == 0){
                tvRanking.setTextColor(Color.parseColor("#fb7299"));
                tvRanking.setTextSize(30);
            } else if (position == 1){
                tvRanking.setTextColor(Color.parseColor("#88fb7299"));
                tvRanking.setTextSize(25);
            } else if (position == 2){
                tvRanking.setTextColor(Color.parseColor("#aafb7299"));
                tvRanking.setTextSize(20);
            }
            tvAllstation.setText(dataBean.getTitle());
            tvUpName.setText(dataBean.getName());
            tvGrade.setText("综合评分 ："+dataBean.getPts());
        }
    }

    //定义接口
    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int position);
    }

    //创建字段有来接收接口实现类的实例
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    //set方法
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
