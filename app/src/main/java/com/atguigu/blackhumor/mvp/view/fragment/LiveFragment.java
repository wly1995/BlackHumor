package com.atguigu.blackhumor.mvp.view.fragment;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.adapter.HomeAdapter;
import com.atguigu.blackhumor.bean.HomeBean;
import com.atguigu.blackhumor.mvp.view.LoadingPagerMvp;
import com.atguigu.blackhumor.utils.Url;

import butterknife.Bind;

/**
 * Created by 万里洋 on 2017/3/20.
 */

public class LiveFragment extends BaseFragment {
    @Bind(R.id.rv_live)
    RecyclerView rvLive;
    @Bind(R.id.live_refresh)
    SwipeRefreshLayout liveRefresh;
    private String url;
    private HomeAdapter homeAdapter;


    @Override
    protected void initListener() {
        liveRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getLoadingPager().loadData();
            }
        });
    }

    @Override
    public LoadingPagerMvp getLoadingPager() {
        return super.getLoadingPager();
    }

    @Override
    protected void initData(String json) {
        this.url = json;
        Log.e("TAG", "initData: " + json);
        processData(json);
        liveRefresh.setRefreshing(false);
    }

    @Override
    public int getLayoutid() {
        return R.layout.fragment_live;
    }

    @Override
    public String getChildUrl() {
        return Url.LIVE_URL;
    }

    private void processData(String response) {
        HomeBean homeBean = JSON.parseObject(response, HomeBean.class);
//        Log.e("TAG",homeBean.getData().getBanner().get(0).getTitle());
        //解析数据成功后开始设置ReclcyView的适配器
        homeAdapter = new HomeAdapter(getActivity(), homeBean.getData());
        //设置适配器
        rvLive.setAdapter(homeAdapter);
        //设置布局管理   1表示一行只有一个item
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 1);
        rvLive.setLayoutManager(manager);
    }
}
