package com.atguigu.blackhumor.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

public class RecommendAdapter extends BaseAdapter {
    private final Context mContext;
    private final RecommendBean data;
    private final List<RecommendBean.DataBean> datas;

    public RecommendAdapter(Context mContext, RecommendBean recommendBean) {
        this.mContext = mContext;
        this.data = recommendBean;
        datas = this.data.getData();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_recommend_gridview, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        RecommendBean.DataBean dataBean = datas.get(position);
        //用Gilde请求图片
        Glide.with(mContext)
                .load(dataBean.getCover())
                .crossFade()
                .into(viewHolder.ivGrid);
//        viewHolder.tvVedio.setText(dataBean.getPlay());
//        viewHolder.tvCommit.setText(dataBean.getDanmaku());
//        viewHolder.tvGridDesc.setText(dataBean.getTitle());
//        viewHolder.tvGridName.setText(dataBean.getName());
        //设置头像
        final ViewHolder finalViewHolder = viewHolder;
        Glide.with(mContext).load(dataBean.getFace()).asBitmap().centerCrop().into(new BitmapImageViewTarget(viewHolder.ivFace) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                finalViewHolder.ivFace.setImageDrawable(circularBitmapDrawable);
            }
        });
        return convertView;
    }


    static class ViewHolder {
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

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
