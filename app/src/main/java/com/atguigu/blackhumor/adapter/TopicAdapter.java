package com.atguigu.blackhumor.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.bean.TopicBean;
import com.atguigu.blackhumor.utils.GlideRoundTransform;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 万里洋 on 2017/3/24.
 */

public class TopicAdapter extends BaseAdapter {
    private final List<TopicBean.ListBean> data;
    private final Context mContext;
    private int j;

    public TopicAdapter(List<TopicBean.ListBean> list, Context mContext) {
        this.data = list;
        this.mContext = mContext;
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
            convertView = View.inflate(mContext, R.layout.item_talk, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        TopicBean.ListBean listBean = data.get(position);
        Glide.with(mContext).load(listBean.getCover()).transform(new GlideRoundTransform(mContext)).into(viewHolder.ivTalk);
        viewHolder.tvTalk.setText(listBean.getTitle());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_talk)
        ImageView ivTalk;
        @Bind(R.id.tv_talk)
        TextView tvTalk;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
