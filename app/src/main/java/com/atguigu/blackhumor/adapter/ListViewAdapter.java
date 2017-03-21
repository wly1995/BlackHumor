package com.atguigu.blackhumor.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.bean.HomeBean;
import com.atguigu.blackhumor.view.NoScrollGridView;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 万里洋 on 2017/3/21.
 */

public class ListViewAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<HomeBean.DataBean.PartitionsBean> data;

    public ListViewAdapter(Context mContext, List<HomeBean.DataBean.PartitionsBean> partitions) {
        this.mContext = mContext;
        this.data = partitions;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_listview, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        HomeBean.DataBean.PartitionsBean partitionsBean = data.get(position);
        //用Gilde请求图片
        Glide.with(mContext)
                .load(partitionsBean.getPartition().getSub_icon().getSrc())
                .crossFade()
                .into(viewHolder.ivLiveHead);
        viewHolder.tvLiveHead.setText(partitionsBean.getPartition().getName());
        GridViewAdapter adapter = new GridViewAdapter(mContext,partitionsBean);
//        viewHolder.tvLiverHead.setText("当前有"+Html.fromHtml(""+partitionsBean.getPartition().getCount())+"个直播");
        viewHolder.gvHot.setAdapter(adapter);

        SpannableStringBuilder builder = new SpannableStringBuilder("当前有"+partitionsBean.getPartition().getCount()+"个直播");

        //ForegroundColorSpan 为文字前景色，BackgroundColorSpan为文字背景色
        ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.parseColor("#fb7299"));
        builder.setSpan(redSpan, 3, (partitionsBean.getPartition().getCount()+"").length()+3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        viewHolder.tvLiverHead.setText(builder);

        SpannableStringBuilder builder1 = new SpannableStringBuilder("还有10条数据，点击刷新");
        builder1.setSpan(redSpan, 2, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        viewHolder.tvRefresh.setText(builder1);
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_live_head)
        ImageView ivLiveHead;
        @Bind(R.id.tv_live_head)
        TextView tvLiveHead;
        @Bind(R.id.tv_liver_head)
        TextView tvLiverHead;
        @Bind(R.id.gv_hot)
        NoScrollGridView gvHot;
        @Bind(R.id.btn_more)
        Button btnMore;
        @Bind(R.id.tv_refresh)
        TextView tvRefresh;
        @Bind(R.id.iv_refresh)
        ImageView ivRefresh;
        @Bind(R.id.ll_refresh)
        LinearLayout llRefresh;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}