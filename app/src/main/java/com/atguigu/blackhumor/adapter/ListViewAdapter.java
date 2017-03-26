package com.atguigu.blackhumor.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.activity.DanmkuVideoActivity;
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
    private RotateAnimation rotate = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
    private AlphaAnimation alpha = new AlphaAnimation(0,1);
    private HomeBean.DataBean.PartitionsBean partitionsBean;

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
        partitionsBean = data.get(position);
        //用Gilde请求图片
        Glide.with(mContext)
                .load(partitionsBean.getPartition().getSub_icon().getSrc())
                .crossFade()
                .into(viewHolder.ivLiveHead);
        viewHolder.tvLiveHead.setText(partitionsBean.getPartition().getName());
        //设置直播的数量
        SpannableStringBuilder builder = new SpannableStringBuilder("当前有"+ partitionsBean.getPartition().getCount()+"个直播");
        //ForegroundColorSpan 为文字前景色，BackgroundColorSpan为文字背景色
        ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.parseColor("#fb7299"));
        builder.setSpan(redSpan, 3, (partitionsBean.getPartition().getCount()+"").length()+3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        viewHolder.tvLiverHead.setText(builder);
        //设置刷新的数据条数
        SpannableStringBuilder builder1 = new SpannableStringBuilder("还有10条数据，点击刷新");
        builder1.setSpan(redSpan, 2, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        viewHolder.tvRefresh.setText(builder1);
        initAnimation(viewHolder);

        //设置gridview的适配器
        GridViewAdapter adapter = new GridViewAdapter(mContext, partitionsBean);
        viewHolder.gvHot.setAdapter(adapter);
        return convertView;
    }

    private void initAnimation(ViewHolder viewHolder) {
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        //旋转动画
        rotate.setDuration(2000);
        rotate.setInterpolator(linearInterpolator);
        //渐变动画
        alpha.setDuration(2000);
        alpha.setInterpolator(linearInterpolator);

        final ViewHolder finalViewHolder = viewHolder;
        viewHolder.llRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext, "llRefresh", Toast.LENGTH_SHORT).show();
                finalViewHolder.ivRefresh.startAnimation(rotate);
                finalViewHolder.tvRefresh.startAnimation(alpha);
            }
        });
        viewHolder.gvHot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(mContext, "position=="+position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext,DanmkuVideoActivity.class);
                intent.putExtra("url",partitionsBean.getLives().get(position));
                mContext.startActivity(intent);
            }
        });
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
