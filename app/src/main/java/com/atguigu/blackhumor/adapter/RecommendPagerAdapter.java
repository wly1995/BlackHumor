package com.atguigu.blackhumor.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.blackhumor.R;

import butterknife.Bind;

/**
 * Created by 万里洋 on 2017/3/22.
 */

public class RecommendPagerAdapter extends PagerAdapter {
    private final Context mContext;
    int[] views = {R.layout.fragment_syn, R.layout.fragment_dynam};
    @Bind(R.id.rv_syn)
    RecyclerView rvSyn;

    public RecommendPagerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View inflate = View.inflate(mContext, views[position], null);
//        rvSyn.setAdapter(adapter);
        container.addView(inflate);
        return inflate;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(View.inflate(mContext, views[position], null));
    }

    @Override
    public int getCount() {
        return views.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
