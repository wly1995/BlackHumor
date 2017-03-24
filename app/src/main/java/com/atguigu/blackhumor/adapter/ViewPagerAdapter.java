package com.atguigu.blackhumor.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.atguigu.blackhumor.fragment.BaseFragment;

import java.util.List;

/**
 * Created by 万里洋 on 2017/3/20.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private String[] titles = new String[]{"直播", "推荐","追番","分区","发现"};
    private final List<BaseFragment> fragments;

    public ViewPagerAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
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
        return titles[position];
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }
}
