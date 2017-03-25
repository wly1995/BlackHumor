package com.atguigu.blackhumor.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.activity.BodyInfoActivity;
import com.atguigu.blackhumor.bean.PartBean;
import com.atguigu.blackhumor.view.NoScrollGridView;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.transformer.CubeInTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 万里洋 on 2017/3/23.
 */

public class PartAdapter extends RecyclerView.Adapter {
    private final Context mContext;
    private final List<PartBean.DataBean> data;
    private final LayoutInflater inflater;
    private static final int GRID_BANNER = 0;
    private static final int GRID = 1;
    private static final int AD = 2;
    private static final int TITLE = 3;
    private static final int ACTIVITY = 4;


    private int currentType;
    int[] pic = {R.drawable.ic_category_t1, R.drawable.ic_head_live, R.drawable.ic_category_t3,
            R.drawable.ic_header_topic, R.drawable.ic_category_t129, R.drawable.ic_category_t4,
            R.drawable.ic_category_t119, R.drawable.ic_header_topic, R.drawable.ic_category_t160,
            R.drawable.ic_header_topic, R.drawable.ic_category_t36, R.drawable.ic_head_live, R.drawable.ic_header_topic,
            R.drawable.ic_category_t155, R.drawable.ic_category_t165, R.drawable.ic_category_t5,
            R.drawable.ic_category_t11, R.drawable.ic_header_topic, R.drawable.ic_category_t23};

    public PartAdapter(Context mContext, List<PartBean.DataBean> data) {
        this.mContext = mContext;
        this.data = data;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == GRID_BANNER) {
            return new GridBannerViewHolder(mContext, inflater.inflate(R.layout.grid_banner, null));
        }
        if (viewType == GRID) {
            return new GridViewHolder(mContext, inflater.inflate(R.layout.item_listview, null));
        }
        if (viewType == AD) {
            return new AdViewHolder(mContext, inflater.inflate(R.layout.item_ad, null));
        }
        if (viewType == TITLE) {
            return new TitleViewHolder(mContext, inflater.inflate(R.layout.item_title, null));
        }
        if (viewType == ACTIVITY) {
            return new ActivityViewHolder(mContext, inflater.inflate(R.layout.banner_viewpager, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == GRID_BANNER) {
            GridBannerViewHolder gridBannerViewHolder = (GridBannerViewHolder) holder;
            gridBannerViewHolder.setData(data, position);
        }
        if (getItemViewType(position) == GRID) {
            GridViewHolder gridViewHolder = (GridViewHolder) holder;
            gridViewHolder.setData(data, position);
        }
        if (getItemViewType(position) == AD) {
            AdViewHolder adViewHolder = (AdViewHolder) holder;
            adViewHolder.setData(data, position);
        }
        if (getItemViewType(position) == TITLE) {
            TitleViewHolder titleViewHolder = (TitleViewHolder) holder;
        }
        if (getItemViewType(position) == ACTIVITY) {
            ActivityViewHolder activityViewHolder = (ActivityViewHolder) holder;
            activityViewHolder.setData(data,position);
        }
    }

    @Override
    public int getItemCount() {
        return data.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            currentType = TITLE;
        } else if (data.get(position - 1).getBanner() != null && "region".equals(data.get(position-1).getType())) {
            currentType = GRID_BANNER;
        } else if (data.get(position - 1).getBanner() == null && "region".equals(data.get(position-1).getType())) {
            currentType = GRID;
        } else if ("topic".equals(data.get(position-1).getType())) {
            currentType = AD;
        } else if ("activity".equals(data.get(position-1).getType())) {
            currentType = ACTIVITY;
        }
        return currentType;
    }


    class GridBannerViewHolder extends RecyclerView.ViewHolder {
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
        @Bind(R.id.banner)
        Banner banner1;

        public GridBannerViewHolder(Context mContext, View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(List<PartBean.DataBean> data, int position) {
            PartGridAdapter adapter = new PartGridAdapter(mContext, data.get(position - 1));
            gvHot.setAdapter(adapter);
//            ivLiveHead.setImageResource(pic[position - 1]);
            tvLiveHead.setText(data.get(position - 1).getTitle());
            tvLiverHead.setText("进去看看");

            SpannableStringBuilder builder = new SpannableStringBuilder("还有10条数据，点击刷新");
            ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.parseColor("#fb7299"));
            builder.setSpan(redSpan, 2, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tvRefresh.setText(builder);


            PartBean.DataBean.BannerBean banner = data.get(position - 1).getBanner();
            List<PartBean.DataBean.BannerBean.BottomBean> bottom = banner.getBottom();
            List<String> images = new ArrayList<>();
            for (int i = 0; i < bottom.size(); i++) {
                images.add(bottom.get(i).getImage());
            }
            //简单使用
            banner1.setImages(images)
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
            banner1.setBannerAnimation(CubeInTransformer.class);
            //banner点击事件
            banner1.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Toast.makeText(mContext, "podition==" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }

        //设置点击事件
        @OnClick({R.id.tv_liver_head, R.id.btn_more, R.id.ll_refresh})
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tv_liver_head:
                    Toast.makeText(mContext, "进去看看", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_more:
                    Toast.makeText(mContext, "获取更多", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.ll_refresh:
//                    Toast.makeText(mContext, "刷新", Toast.LENGTH_SHORT).show();

                    //旋转动画
                    rotate.setDuration(2000);
                    rotate.setInterpolator(linearInterpolator);
                    //渐变动画
                    alpha.setDuration(2000);
                    alpha.setInterpolator(linearInterpolator);

                    ivRefresh.startAnimation(rotate);
                    tvRefresh.startAnimation(alpha);
                    break;
            }
        }
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        private final Context mContext;
        @Bind(R.id.gv_hot)
        NoScrollGridView gvHot;
        @Bind(R.id.iv_live_head)
        ImageView ivLiveHead;
        @Bind(R.id.tv_live_head)
        TextView tvLiveHead;
        @Bind(R.id.tv_liver_head)
        TextView tvLiverHead;
        @Bind(R.id.btn_more)
        Button btnMore;
        @Bind(R.id.tv_refresh)
        TextView tvRefresh;
        @Bind(R.id.iv_refresh)
        ImageView ivRefresh;
        @Bind(R.id.ll_refresh)
        LinearLayout llRefresh;

        public GridViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            ButterKnife.bind(this, itemView);
        }

        public void setData(List<PartBean.DataBean> data, int position) {

            PartGridAdapter adapter = new PartGridAdapter(mContext, data.get(position - 1));
            gvHot.setAdapter(adapter);
            //用Gilde请求图片
//            Glide.with(mContext)
//                    .load(livesBean.getCover().getSrc())
//                    .crossFade()
//                    .into(viewHolder.ivGrid);
//            ivLiveHead.setImageResource(pic[position+1]);
            tvLiveHead.setText(data.get(position - 1).getTitle());
            tvLiverHead.setText("进去看看");

            SpannableStringBuilder builder = new SpannableStringBuilder("还有10条数据，点击刷新");
            ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.parseColor("#fb7299"));
            builder.setSpan(redSpan, 2, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tvRefresh.setText(builder);
        }

        //设置点击事件
        @OnClick({R.id.tv_liver_head, R.id.btn_more, R.id.ll_refresh})
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tv_liver_head:
                    Toast.makeText(mContext, "进去看看", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_more:
                    Toast.makeText(mContext, "获取更多", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.ll_refresh:
                    //旋转动画
                    rotate.setDuration(2000);
                    rotate.setInterpolator(linearInterpolator);
                    //渐变动画
                    alpha.setDuration(2000);
                    alpha.setInterpolator(linearInterpolator);

                    ivRefresh.startAnimation(rotate);
                    tvRefresh.startAnimation(alpha);
                    break;
            }
        }
    }

    class AdViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_live_head)
        ImageView ivLiveHead;
        @Bind(R.id.tv_live_head)
        TextView tvLiveHead;
        @Bind(R.id.tv_liver_head)
        TextView tvLiverHead;
        @Bind(R.id.iv_ad)
        ImageView ivAd;
        private PartBean.DataBean.BodyBean bodybean;

        public AdViewHolder(Context mContext, View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(List<PartBean.DataBean> data, int position) {
            ivLiveHead.setImageResource(pic[position - 1]);
            tvLiveHead.setText("话题");
            tvLiverHead.setText("进去看看");
            bodybean = data.get(position - 1).getBody().get(0);
            //用Gilde请求图片
            Glide.with(mContext)
                    .load(bodybean.getCover())
                    .crossFade()
                    .into(ivAd);
        }

        @OnClick({R.id.tv_liver_head, R.id.iv_ad})
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tv_liver_head:
                    Toast.makeText(mContext, "进去看看", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.iv_ad:
//                    Toast.makeText(mContext, "广告", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, BodyInfoActivity.class);
                    intent.putExtra("body", bodybean);
                    mContext.startActivity(intent);
                    break;
            }
        }
    }

    class TitleViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.grid_title)
        NoScrollGridView gridTitle;

        public TitleViewHolder(Context mContext, View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            TitleGridAdapter adapter = new TitleGridAdapter(mContext);
            gridTitle.setAdapter(adapter);
        }
    }

    class ActivityViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.banner)
        Banner banner1;
        public ActivityViewHolder(Context mContext, View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setData(List<PartBean.DataBean> data, int position) {
            List<PartBean.DataBean.BodyBean> body = data.get(position-1).getBody();
            List<String> images = new ArrayList<>();
            for (int i = 0; i < body.size(); i++) {
                images.add(body.get(i).getCover());
            }
            //简单使用
            banner1.setImages(images)
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
            banner1.setBannerAnimation(CubeInTransformer.class);
            //banner点击事件
            banner1.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Toast.makeText(mContext, "podition==" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private RotateAnimation rotate = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
    private AlphaAnimation alpha = new AlphaAnimation(0, 1);
    private LinearInterpolator linearInterpolator = new LinearInterpolator();
}
