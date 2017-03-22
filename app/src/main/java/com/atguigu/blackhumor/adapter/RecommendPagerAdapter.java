package com.atguigu.blackhumor.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.blackhumor.pager.DyncPager;
import com.atguigu.blackhumor.pager.SynPager;
import com.atguigu.blackhumor.view.LoadingPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 万里洋 on 2017/3/22.
 */

public class RecommendPagerAdapter extends PagerAdapter {
    private final Context mContext;
    private List<LoadingPager> basepagers ;
    private LoadingPager loadingPager;

    public RecommendPagerAdapter(Context mContext) {
        this.mContext = mContext;
        basepagers = new ArrayList<>();
        basepagers.add(new SynPager(mContext));
        basepagers.add(new DyncPager(mContext));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        loadingPager = basepagers.get(position);
        container.addView(loadingPager);
        return loadingPager;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(loadingPager);
    }

    @Override
    public int getCount() {
        return basepagers.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
