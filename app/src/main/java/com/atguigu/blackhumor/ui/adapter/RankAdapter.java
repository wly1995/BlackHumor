package com.atguigu.blackhumor.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.atguigu.blackhumor.ui.fragment.BaseFragment;

import java.util.List;

/**
 * Created by 万里洋 on 2017/3/24.
 */

public class RankAdapter extends FragmentPagerAdapter {
    String[] titles = {"原创","全站","番剧"};
    private final List<BaseFragment> data;

    public RankAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        this.data = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
