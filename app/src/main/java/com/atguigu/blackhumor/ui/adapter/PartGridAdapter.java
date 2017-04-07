package com.atguigu.blackhumor.ui.adapter;

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
import com.atguigu.blackhumor.service.entity.PartBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 万里洋 on 2017/3/23.
 */

public class PartGridAdapter extends BaseAdapter {
    private final PartBean.DataBean data;
    private final List<PartBean.DataBean.BodyBean> body;
    private final Context mContext;

    public PartGridAdapter(Context mContext, PartBean.DataBean dataBean) {
        this.data = dataBean;
        body = data.getBody();
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return body.size();
    }

    @Override
    public Object getItem(int position) {
        return body.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
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
        PartBean.DataBean.BodyBean bodyBean = body.get(position);
        //用Gilde请求图片
            Glide.with(mContext)
                    .load(bodyBean.getCover())
                    .crossFade()
                    .into(viewHolder.ivGrid);
            viewHolder.tvCommit.setText(bodyBean.getDanmaku()+"");
            viewHolder.tvVedio.setText(bodyBean.getPlay()+"");
            viewHolder.tvGridName.setText(bodyBean.getTitle());
        //设置头像
        final ViewHolder finalViewHolder = viewHolder;
        Glide.with(mContext).load(bodyBean.getCover()).asBitmap().centerCrop().into(new BitmapImageViewTarget(finalViewHolder.ivFace) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                finalViewHolder.ivFace.setImageDrawable(circularBitmapDrawable);
            }
        });
        viewHolder.tvGridDesc.setText(bodyBean.getTitle());

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
