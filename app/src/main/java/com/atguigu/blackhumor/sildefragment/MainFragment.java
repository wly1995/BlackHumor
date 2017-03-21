package com.atguigu.blackhumor.sildefragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.adapter.ViewPagerAdapter;
import com.atguigu.blackhumor.fragment.AftersomeFragment;
import com.atguigu.blackhumor.fragment.BaseFragment;
import com.atguigu.blackhumor.fragment.DiscoveryFragment;
import com.atguigu.blackhumor.fragment.LiveFragment;
import com.atguigu.blackhumor.fragment.PartitionFragment;
import com.atguigu.blackhumor.fragment.RecommendFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by 万里洋 on 2017/3/21.
 */

public class MainFragment extends BaseFragment {
    @Bind(R.id.tb_main)
    TabLayout tbMain;
    @Bind(R.id.vp_main)
    ViewPager vpMain;
    @Bind(R.id.iv_home)
    ImageView ivHome;
    @Bind(R.id.tv_user)
    TextView tvUser;
    @Bind(R.id.tv_login)
    TextView tvLogin;
    @Bind(R.id.iv_game)
    ImageView ivGame;
    @Bind(R.id.iv_download)
    ImageView ivDownload;
    @Bind(R.id.iv_search)
    ImageView ivSearch;
    @Bind(R.id.content_main)
    LinearLayout contentMain;
    private ArrayList<BaseFragment> fragments;

    @Override
    protected void initListener() {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    protected void initData() {
        Log.e("TAG", "initData");
        initFragement();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        ViewPagerAdapter adapter = new ViewPagerAdapter(fragmentManager, fragments);
        vpMain.setAdapter(adapter);
        tbMain.setupWithViewPager(vpMain);
    }

    private void initFragement() {
        fragments = new ArrayList<>();
        fragments.add(new LiveFragment());
        fragments.add(new RecommendFragment());
        fragments.add(new AftersomeFragment());
        fragments.add(new PartitionFragment());
        fragments.add(new DiscoveryFragment());
    }

    @Override
    public int getLayoutid() {
        return R.layout.fragment_main;
    }
    @OnClick({R.id.iv_home, R.id.tv_user, R.id.tv_login, R.id.iv_game, R.id.iv_download, R.id.iv_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_home:
                DrawerLayout drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.tv_user:
                break;
            case R.id.tv_login:
                break;
            case R.id.iv_game:
                break;
            case R.id.iv_download:
                break;
            case R.id.iv_search:
                break;
        }
    }
}
