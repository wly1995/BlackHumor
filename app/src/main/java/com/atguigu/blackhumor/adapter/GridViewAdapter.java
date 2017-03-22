package com.atguigu.blackhumor.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.bean.HomeBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 万里洋 on 2017/3/21.
 */

public class GridViewAdapter extends BaseAdapter {
    private final Context mContext;
    private final HomeBean.DataBean.PartitionsBean data;
    private final List<HomeBean.DataBean.PartitionsBean.LivesBean> lives;


    public GridViewAdapter(Context mContext, HomeBean.DataBean.PartitionsBean partitionsBean) {
        this.mContext = mContext;
        this.data = partitionsBean;
        lives = data.getLives();
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return lives.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_gridview, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        HomeBean.DataBean.PartitionsBean.LivesBean livesBean = lives.get(position);
//用Gilde请求图片
        Glide.with(mContext)
                .load(livesBean.getCover().getSrc())
                .crossFade()
                .into(viewHolder.ivGrid);
//        Glide.with(mContext)
//                .load(livesBean.getOwner().getFace())
//                .crossFade()
//                .into(viewHolder.ivFace);
        final ViewHolder finalViewHolder = viewHolder;
        Glide.with(mContext).load(livesBean.getOwner().getFace()).asBitmap().centerCrop().into(new BitmapImageViewTarget(viewHolder.ivFace) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                finalViewHolder.ivFace.setImageDrawable(circularBitmapDrawable);
            }
        });
        viewHolder.tvGridName.setText(livesBean.getTitle());
        viewHolder.tvGridDesc.setText(livesBean.getOwner().getName());
        viewHolder.tvGridCount.setText(livesBean.getOnline() + "");

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_face)
        ImageView ivFace;
        @Bind(R.id.card_view)
        CardView cardView;
        @Bind(R.id.iv_grid)
        ImageView ivGrid;
        @Bind(R.id.tv_grid_name)
        TextView tvGridName;
        @Bind(R.id.tv_grid_desc)
        TextView tvGridDesc;
        @Bind(R.id.tv_grid_count)
        TextView tvGridCount;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
