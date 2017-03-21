package com.atguigu.blackhumor.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.activity.BannerInfoActivity;
import com.atguigu.blackhumor.bean.HomeBean;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.transformer.CubeInTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 万里洋 on 2017/3/21.
 */

public class HomeAdapter extends RecyclerView.Adapter {
    private final Context mContext;
    private final HomeBean.DataBean data;
    /**
     * 六种类型
     */
    /**
     * 横幅广告-要从0开
     */
    public static final int BANNER = 0;
    /**
     * 频道
     */
    public static final int CHANNEL = 1;

    /**
     * 推荐主播
     */
    public static final int RECOMMEND = 2;

    /**
     * 绘画专区
     */
    public static final int PAINT = 3;
    /**
     * 生活娱乐
     */
    public static final int ENJOY = 4;
    /**
     * 唱见舞见
     */
    public static final int SING = 5;
    /**
     * 用它来加载各个item的视图
     */
    private final LayoutInflater inflater;

    private int currentType;

    public HomeAdapter(Context context, HomeBean.DataBean data) {
        this.mContext = context;
        this.data = data;

        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BANNER) {
            //返回banneritem对应的视图
            return new BannerViewHolder(mContext, inflater.inflate(R.layout.banner_viewpager, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == BANNER) {
            BannerViewHolder viewHolder = (BannerViewHolder) holder;
            //绑定数据,把数据传递给banner的V
            viewHolder.setData(data.getBanner());
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == BANNER) {
            currentType = BANNER;
        } else if (position == CHANNEL) {
            currentType = CHANNEL;
        } else if (position == RECOMMEND) {
            currentType = RECOMMEND;
        } else if (position == PAINT) {
            currentType = PAINT;
        } else if (position == ENJOY) {
            currentType = ENJOY;
        } else if (position == SING) {
            currentType = SING;
        }
        return currentType;
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        private final Context mContext;
        private final Banner banner;

        public BannerViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            banner = (Banner) itemView.findViewById(R.id.banner);
        }


        public void setData(List<HomeBean.DataBean.BannerBean> banner_info) {
            //1.得到数据
            //2.设置Banner的数据
            List<String> images = new ArrayList<>();
            final HomeBean.DataBean.BannerBean bannerBean = banner_info.get(0);
            for (int i = 0; i < 5; i++) {
                images.add(bannerBean.getImg());
            }

            //简单使用
            banner.setImages(images)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            //具体方法内容自己去选择，次方法是为了减少banner过多的依赖第三方包，所以将这个权限开放给使用者去选择
                            Glide.with(context)
                                    .load(path)
                                    .crossFade()
                                    .into(imageView);
                        }
                    })
                    .start();

            //设置样式
            banner.setBannerAnimation(CubeInTransformer.class);
            //点击事件
            banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Toast.makeText(mContext, "position=="+position, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, BannerInfoActivity.class);
                    intent.putExtra("banner",bannerBean);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
