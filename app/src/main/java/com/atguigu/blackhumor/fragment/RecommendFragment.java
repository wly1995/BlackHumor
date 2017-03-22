package com.atguigu.blackhumor.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.adapter.RecommendPagerAdapter;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by 万里洋 on 2017/3/20.
 */

public class RecommendFragment extends BaseFragment {
    @Bind(R.id.tab)
    TabLayout tab;
    @Bind(R.id.iv_recommend)
    ImageView ivRecommend;
    @Bind(R.id.ll_recommend)
    RelativeLayout llRecommend;
    @Bind(R.id.vp_recommend)
    ViewPager vpRecommend;
    String[] titles = {"综合","动态"};
    @Override
    protected void initListener() {

    }


    @Override
    protected void initData() {
            RecommendPagerAdapter adapter = new RecommendPagerAdapter(getActivity());
            vpRecommend.setAdapter(adapter);
            tab.setupWithViewPager(vpRecommend);


            for (int i = 0; i < adapter.getCount(); i++) {
                TabLayout.Tab tablayout = tab.getTabAt(i);//获得每一个tab
                tablayout.setCustomView(R.layout.tab_item);//给每一个tab设置view
                if (i == 0) {
                    // 设置第一个tab的TextView是被选择的样式
                    tablayout.getCustomView().findViewById(R.id.tab_text).setSelected(true);//第一个tab被选中
                }
                TextView textView = (TextView) tablayout.getCustomView().findViewById(R.id.tab_text);
                textView.setText(titles[i]);//设置tab上的文字
                textView.setTextSize(15);
            }
            tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    tab.getCustomView().findViewById(R.id.tab_text).setSelected(true);
                    vpRecommend.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                    tab.getCustomView().findViewById(R.id.tab_text).setSelected(false);
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
    }
    @Override
    public int getLayoutid() {
        return R.layout.fragment_recommend;
    }

    @OnClick(R.id.iv_recommend)
    public void onClick() {
        Toast.makeText(getActivity(), "添加标签", Toast.LENGTH_SHORT).show();
    }
}
