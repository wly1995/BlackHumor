package com.atguigu.blackhumor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.bean.SearchBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 万里洋 on 2017/3/27.
 */

public class ComprehensiveAdapter extends RecyclerView.Adapter<ComprehensiveAdapter.MyViewHolder> {

    private final Context mContext;
    private final SearchBean.DataBean.ItemsBean data;
    private final List<SearchBean.DataBean.ItemsBean.ArchiveBean> archive;


    public ComprehensiveAdapter(Context mContext, SearchBean.DataBean.ItemsBean items) {
        this.mContext = mContext;
        this.data = items;
        archive = data.getArchive();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(View.inflate(mContext, R.layout.item_comprehensive, null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.setData(archive, position);
    }

    @Override
    public int getItemCount() {
        return archive.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_cover)
        ImageView ivCover;
        @Bind(R.id.tv_durtion)
        TextView tvDurtion;
        @Bind(R.id.tv_desc)
        TextView tvDesc;
        @Bind(R.id.tv_username)
        TextView tvUsername;
        @Bind(R.id.play_count)
        TextView playCount;
        @Bind(R.id.danmaku_count)
        TextView danmakuCount;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setData(List<SearchBean.DataBean.ItemsBean.ArchiveBean> archive, int position) {
            SearchBean.DataBean.ItemsBean.ArchiveBean archiveBean = archive.get(position);
            tvDesc.setText(archiveBean.getTitle());
            tvDurtion.setText(archiveBean.getDuration());
            tvUsername.setText(archiveBean.getAuthor());
            Glide.with(mContext).load(archiveBean.getCover()).into(ivCover);
            playCount.setText(String.format("%.2f", Double.parseDouble(archiveBean.getPlay()+"") / 10000 ) +"万");
            if (Double.parseDouble(archiveBean.getDanmaku()+"") > 10000){
                danmakuCount.setText(String.format("%.2f", Double.parseDouble(archiveBean.getDanmaku()+"") / 10000 ) +"万");
            }else{
                danmakuCount.setText(archiveBean.getDanmaku()+"");
            }
        }
    }
}
