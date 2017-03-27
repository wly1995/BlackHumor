package com.atguigu.blackhumor.sildefragment;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.activity.LoginActivity;
import com.atguigu.blackhumor.adapter.ViewPagerAdapter;
import com.atguigu.blackhumor.fragment.AftersomeFragment;
import com.atguigu.blackhumor.fragment.BaseFragment;
import com.atguigu.blackhumor.fragment.DiscoveryFragment;
import com.atguigu.blackhumor.fragment.LiveFragment;
import com.atguigu.blackhumor.fragment.PartitionFragment;
import com.atguigu.blackhumor.fragment.RecommendFragment;
import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;

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
//    @Bind(R.id.content_main)
//    LinearLayout contentMain;
    private ArrayList<BaseFragment> fragments;
    private DrawerLayout drawerLayout;
    SearchFragment searchFragment = SearchFragment.newInstance();
    @Override
    protected void initListener() {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
//        getActivity().setSupportActionBar(toolbar);
    }

    @Override
    protected void initData(String json) {
        Log.e("TAG", "initData");
        initFragement();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        ViewPagerAdapter adapter = new ViewPagerAdapter(fragmentManager, fragments);
        vpMain.setAdapter(adapter);
        tbMain.setupWithViewPager(vpMain);
        vpMain.setCurrentItem(1);
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

    @Override
    public String getChildUrl() {
        return null;
    }



    @OnClick({R.id.iv_home, R.id.tv_user, R.id.tv_login, R.id.iv_game, R.id.iv_download, R.id.iv_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_home:
                drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
               break;
            case R.id.tv_user:
//                Toast.makeText(getActivity(), "用户头像", Toast.LENGTH_SHORT).show();
                drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.tv_login:
//                Toast.makeText(getActivity(), "登录", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(),LoginActivity.class));
                break;
            case R.id.iv_game:
                Toast.makeText(getActivity(), "游戏中心", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_download:
                Toast.makeText(getActivity(), "下载", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_search:
//                Toast.makeText(getActivity(), "查找", Toast.LENGTH_SHORT).show();
                searchFragment.setOnSearchClickListener(new IOnSearchClickListener() {
                    @Override
                    public void OnSearchClick(String keyword) {
                        Toast.makeText(getActivity(), ""+keyword, Toast.LENGTH_SHORT).show();
                    }
                });
                searchFragment.show(getFragmentManager(),SearchFragment.TAG);
                break;
        }
    }
}
