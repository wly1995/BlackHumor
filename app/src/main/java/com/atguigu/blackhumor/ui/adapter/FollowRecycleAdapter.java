package com.atguigu.blackhumor.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.service.entity.FollowBean;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 万里洋 on 2017/3/23.
 */

public class FollowRecycleAdapter extends RecyclerView.Adapter {
    private final Context mContext;
    private final FollowBean.ResultBean datas;

    private final LayoutInflater inflater;
    private static final int HEAD = 1;
    private static final int BANNER = 0;
    private static final int DEVIDE = 2;

    private int currentType = BANNER;
    private static final int NewShow = 3;

    public FollowRecycleAdapter(Context mContext, FollowBean.ResultBean resultBean) {
        this.mContext = mContext;
        this.datas = resultBean;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == HEAD){
            currentType = HEAD;
        } else if (position == BANNER) {
            currentType = BANNER;
        } else if (position == DEVIDE) {
            currentType = DEVIDE;
        } else if (position == NewShow) {
            currentType = NewShow;
        }
        return currentType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEAD){
            return new HeadViewHolder(mContext,inflater.inflate(R.layout.rv_head,null));
        }
        if (viewType == BANNER) {
            return new BannerViewHolder(mContext, inflater.inflate(R.layout.banner_viewpager, null));
        }
        if (viewType == DEVIDE) {
            return new DeVideViewHolder(mContext, inflater.inflate(R.layout.devide_item, null));
        }
        if (viewType == NewShow) {
            return new NewShowViewHolder(mContext, inflater.inflate(R.layout.new_show, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == HEAD){
            HeadViewHolder headViewHolder = (HeadViewHolder) holder;
        }
        if (getItemViewType(position) == BANNER) {
            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
            bannerViewHolder.setData(datas.getAd().getHead());
        }
        if (getItemViewType(position) == DEVIDE) {
            DeVideViewHolder deVideViewHolder = (DeVideViewHolder) holder;
        }
        if (getItemViewType(position) == NewShow) {
            NewShowViewHolder newShowViewHolder = (NewShowViewHolder) holder;
            newShowViewHolder.setData(datas.getSerializing());
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class HeadViewHolder extends RecyclerView.ViewHolder{

        public HeadViewHolder(Context mContext, View itemView) {
            super(itemView);
        }
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        Banner banner;

        BannerViewHolder(Context mcontext, View view) {
            super(view);
            this.context = mcontext;
            banner = (Banner) view.findViewById(R.id.banner);
        }

        public void setData(List<FollowBean.ResultBean.AdBean.HeadBean> bean) {
            List<String> images = new ArrayList<>();
            for (int i = 0; i < bean.size(); i++) {
                images.add(bean.get(i).getImg());
            }
            banner.setImages(images)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            //获取图片
                            Glide.with(context)
                                    .load(path).crossFade()
                                    .into(imageView);
                        }
                    }).start();
            banner.setBannerAnimation(Transformer.Accordion);
            banner.isAutoPlay(false);
            banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Toast.makeText(context, "position" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    class DeVideViewHolder extends RecyclerView.ViewHolder {

        TextView tvAllSerial;
        DeVideViewHolder(final Context mcontext, View view) {
            super(view);
            tvAllSerial = (TextView) view.findViewById(R.id.tv_all_serial);
            tvAllSerial.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mcontext, "加载更多", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    class NewShowViewHolder extends RecyclerView.ViewHolder {
        private final Context mcontext;
        private GridView gvShow;
        private FollowGridViewAdapter followGridViewAdapter;

        NewShowViewHolder(Context mcontext, View view) {
            super(view);
            this.mcontext = mcontext;
            gvShow = (GridView) view.findViewById(R.id.gv_show);
        }

        public void setData(List<FollowBean.ResultBean.SerializingBean> serializing) {
            followGridViewAdapter = new FollowGridViewAdapter(mcontext, serializing);
            gvShow.setAdapter(followGridViewAdapter);
        }
    }
}
