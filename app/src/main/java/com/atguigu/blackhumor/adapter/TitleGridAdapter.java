package com.atguigu.blackhumor.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.blackhumor.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 万里洋 on 2017/3/21.
 */

public class TitleGridAdapter extends BaseAdapter {
    private final Context mContext;
    int[] list = {R.drawable.ic_head_live, R.drawable.ic_category_t13, R.drawable.ic_category_t1, R.drawable.ic_head_live_banggumu,
            R.drawable.ic_category_t3, R.drawable.ic_category_t129, R.drawable.ic_category_t4, R.drawable.ic_category_t36,
            R.drawable.ic_category_t160, R.drawable.ic_category_t119, R.drawable.ic_category_t155, R.drawable.ic_category_t165,
            R.drawable.ic_category_t5, R.drawable.ic_category_t23, R.drawable.ic_category_t11, R.drawable.ic_category_game_center};

    String[] data = {"直播", "番剧", "动画", "国创", "音乐", "舞蹈", "游戏", "科技", "生活", "鬼畜", "时尚", "广告", "娱乐", "电影", "电视剧", "游戏中戏"};

    public TitleGridAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_grid_title, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
            viewHolder.ivAaaa.setImageResource(list[position]);
            viewHolder.tvAaaa.setText(data[position]);
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_aaaa)
        ImageView ivAaaa;
        @Bind(R.id.tv_aaaa)
        TextView tvAaaa;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
