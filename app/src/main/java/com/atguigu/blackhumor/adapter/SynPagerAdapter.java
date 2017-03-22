package com.atguigu.blackhumor.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.bean.RecommendBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 万里洋 on 2017/3/22.
 */

public class SynPagerAdapter extends RecyclerView.Adapter<SynPagerAdapter.MyViewHolder> {
    private final Context mContext;
    private final RecommendBean datas;
    private final List<RecommendBean.DataBean> data;

    public SynPagerAdapter(Context mContext, RecommendBean recommendBean) {
        this.mContext = mContext;
        this.datas = recommendBean;
        data = datas.getData();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_recommend_gridview, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.setData(data,position);

    }

    @Override
    public int getItemCount() {
        return data.size();
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

    class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_grid)
        ImageView ivGrid;
        @Bind(R.id.tv_vedio)
        TextView tvVedio;
        @Bind(R.id.tv_commit)
        TextView tvCommit;
        @Bind(R.id.tv_grid_name)
        TextView tvGridName;
        @Bind(R.id.iv_face)
        ImageView ivFace;
        @Bind(R.id.tv_grid_desc)
        TextView tvGridDesc;
        @Bind(R.id.tv_grid_count)
        TextView tvGridCount;
        public MyViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null){
                        mOnItemClickListener.onItemClick(itemView,getLayoutPosition());
                    }
                }
            });
        }

        public void setData(List<RecommendBean.DataBean> data, int position) {
            RecommendBean.DataBean dataBean = data.get(position);
            //用Gilde请求图片
            Glide.with(mContext)
                    .load(dataBean.getCover())
                    .crossFade()
                    .into(ivGrid);
            tvVedio.setText(dataBean.getPlay()+"");
            tvCommit.setText(dataBean.getDanmaku()+"");
            tvGridDesc.setText(dataBean.getTitle());
            tvGridName.setText(dataBean.getName());
            //设置头像
            Glide.with(mContext).load(dataBean.getFace()).asBitmap().centerCrop().into(new BitmapImageViewTarget(ivFace) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    ivFace.setImageDrawable(circularBitmapDrawable);
                }
            });
        }


    }
}
