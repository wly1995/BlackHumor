package com.atguigu.blackhumor.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.atguigu.blackhumor.fragment.BaseFragment;

import java.util.List;

/**
 * Created by 万里洋 on 2017/3/27.
 */

public class SearchAdapter extends FragmentPagerAdapter {
    private String[] titles = {"综合","番剧","UP主","影视"};
    private final List<BaseFragment> data;

    public SearchAdapter(FragmentManager fm, List<BaseFragment> fragments) {
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

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }
}
