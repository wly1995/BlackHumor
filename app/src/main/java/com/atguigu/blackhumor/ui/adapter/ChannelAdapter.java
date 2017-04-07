package com.atguigu.blackhumor.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.service.entity.HomeBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 万里洋 on 2017/3/21.
 */

public class ChannelAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<HomeBean.DataBean.EntranceIconsBean> datas;
    int[] image = {R.drawable.live_home_follow_anchor,
            R.drawable.live_home_live_center,
            R.drawable.live_home_clip_video,
            R.drawable.live_home_search_room,
            R.drawable.live_home_all_category,
    };
    String[] text = {"关注","中心","小视频","搜索","分类"};
    public ChannelAdapter(Context mContext, List<HomeBean.DataBean.EntranceIconsBean> entranceIcons) {
        this.mContext = mContext;
        this.datas = entranceIcons;
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_channel, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //设置数据
        HomeBean.DataBean.EntranceIconsBean entranceIconsBean = datas.get(position);
        viewHolder.tvChannel.setText(text[position]);

//        //用Gilde请求图片
//        Glide.with(mContext)
//                .load(entranceIconsBean.getEntrance_icon().getSrc())
//                .crossFade()
//                .into(viewHolder.ivChannel);
        viewHolder.ivChannel.setImageResource(image[position]);
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_channel)
        ImageView ivChannel;
        @Bind(R.id.tv_channel)
        TextView tvChannel;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
