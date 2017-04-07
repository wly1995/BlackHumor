package com.atguigu.blackhumor.ui.activity;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextPaint;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.service.entity.RecommendBean;
import com.atguigu.blackhumor.ui.fragment.AftersomeFragment;
import com.atguigu.blackhumor.ui.fragment.BaseFragment;
import com.atguigu.blackhumor.ui.fragment.DiscoveryFragment;
import com.atguigu.blackhumor.ui.view.AppBarStateChangeEvent;
import com.atguigu.blackhumor.utils.DisplayUtil;
import com.atguigu.blackhumor.utils.SystemBarHelper;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 视频详情页面
 */
public class VideoDetailsActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Bind(R.id.video_preview)
    ImageView mVideoPreview;

    @Bind(R.id.tab_layout)
    SlidingTabLayout mSlidingTabLayout;

    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    @Bind(R.id.fab)
    FloatingActionButton mFAB;

    @Bind(R.id.app_bar_layout)
    AppBarLayout mAppBarLayout;

    @Bind(R.id.tv_player)
    TextView mTvPlayer;

    @Bind(R.id.tv_av)
    TextView mAvText;
    private RecommendBean.DataBean dataBean;
    private List<BaseFragment> fragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();


    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        getData();
    }

    private void getData() {
        dataBean = (RecommendBean.DataBean) getIntent().getSerializableExtra("video");

        Glide.with(VideoDetailsActivity.this)
                .load(dataBean.getCover())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into(mVideoPreview);
        mFAB.setClickable(false);
//        mFAB.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.gray_20)));
        mFAB.setTranslationY(-getResources().getDimension(R.dimen.floating_action_button_size_half));
//        mFAB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                VideoPlayerActivity.launch(VideoDetailsActivity.this,
//                        dataBean.getUri(), dataBean.getTitle());
//            }
//        });
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                setViewsTranslation(verticalOffset);
            }
        });
        mAppBarLayout.addOnOffsetChangedListener(new AppBarStateChangeEvent() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state, int verticalOffset) {

                if (state == State.EXPANDED) {
                    //展开状态
                    mTvPlayer.setVisibility(View.GONE);
                    mAvText.setVisibility(View.VISIBLE);
                    mToolbar.setContentInsetsRelative(DisplayUtil.dp2px(VideoDetailsActivity.this, 15), 0);
                } else if (state == State.COLLAPSED) {
                    //折叠状态
                    mTvPlayer.setVisibility(View.VISIBLE);
                    mAvText.setVisibility(View.GONE);
                    mToolbar.setContentInsetsRelative(DisplayUtil.dp2px(VideoDetailsActivity.this, 150), 0);
                } else {
                    mTvPlayer.setVisibility(View.GONE);
                    mAvText.setVisibility(View.VISIBLE);
                    mToolbar.setContentInsetsRelative(DisplayUtil.dp2px(VideoDetailsActivity.this, 15), 0);
                }
            }
        });

        fragments.add(new DiscoveryFragment());
        fragments.add(new AftersomeFragment());

        setPagerTitle(String.valueOf(dataBean.getDanmaku()));
    }


    private void setViewsTranslation(int target) {

        mFAB.setTranslationY(target);
        if (target == 0) {
            showFAB();
        } else if (target < 0) {
            hideFAB();
        }
    }


    private void showFAB() {

        mFAB.animate().scaleX(1f).scaleY(1f)
                .setInterpolator(new OvershootInterpolator())
                .start();

        mFAB.setClickable(true);
    }


    private void hideFAB() {

        mFAB.animate().scaleX(0f).scaleY(0f)
                .setInterpolator(new AccelerateInterpolator())
                .start();

        mFAB.setClickable(false);
    }
    @Override
    protected void initTitle() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        //设置还没收缩时状态下字体颜色
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);
        //设置收缩后Toolbar上字体的颜色
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);

        //设置StatusBar透明
        SystemBarHelper.immersiveStatusBar(this);
        SystemBarHelper.setHeightAndPadding(this, mToolbar);
    }

    @Override
    public int getLayoutid() {
        return R.layout.activity_video_details;
    }




    private void setPagerTitle(String num) {

        titles.add("简介");
        titles.add("评论" + "(" + num + ")");

        VideoDetailsPagerAdapter mAdapter = new VideoDetailsPagerAdapter(getSupportFragmentManager(),fragments, titles);

        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(2);
        mSlidingTabLayout.setViewPager(mViewPager);
        measureTabLayoutTextWidth(0);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }


            @Override
            public void onPageSelected(int position) {

                measureTabLayoutTextWidth(position);
            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void measureTabLayoutTextWidth(int position) {

        String title = titles.get(position);
        TextView titleView = mSlidingTabLayout.getTitleView(position);
        TextPaint paint = titleView.getPaint();
        float textWidth = paint.measureText(title);
        mSlidingTabLayout.setIndicatorWidth(textWidth / 3);
    }


    public static class VideoDetailsPagerAdapter extends FragmentStatePagerAdapter {

        private List<BaseFragment> fragments;

        private List<String> titles;


        VideoDetailsPagerAdapter(FragmentManager fm, List<BaseFragment> fragments, List<String> titles) {

            super(fm);
            this.fragments = fragments;
            this.titles = titles;
        }


        @Override
        public Fragment getItem(int position) {

            return fragments.get(position);
        }


        @Override
        public int getCount() {

            return fragments.size();
        }


        @Override
        public CharSequence getPageTitle(int position) {

            return titles.get(position);
        }
    }
}
