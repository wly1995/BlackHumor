package com.atguigu.blackhumor.fragment;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.adapter.HomeAdapter;
import com.atguigu.blackhumor.bean.HomeBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;

import butterknife.Bind;
import okhttp3.Call;

/**
 * Created by 万里洋 on 2017/3/20.
 */

public class LiveFragment extends BaseFragment {

    @Bind(R.id.rv_live)
    RecyclerView rvLive;
    private HomeAdapter homeAdapter;
    private ArrayList<BaseFragment> fragments;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        Log.e("TAG","initData");
        getDataFromNet();
    }

    private void getDataFromNet() {
        OkHttpUtils
                .get()
                .url("http://live.bilibili.com/AppNewIndex/common?_device=android&appkey=\n" +
                        "1d8b6e7d45233436&build=501000&mobi_app=android&platform=android&scale=\n" +
                        "hdpi&ts=1490013188000&sign=92541a11ed62841120e786e637b9db3b")
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "联网失败==" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "联网成功==" + response);
                        processData(response);
                    }
                });
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
        //设置滑动到哪个位置了的监听
//        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                if (position <= 4) {//小于3条item的时候隐藏
//                    ibTop.setVisibility(View.GONE);
//                } else {//大于的时候显示
//                    ibTop.setVisibility(View.VISIBLE);
//                }
//                //只能返回1
//                return 1;
//            }
//        });
        rvLive.setLayoutManager(manager);
    }

    @Override
    public int getLayoutid() {
        return R.layout.fragment_live;
    }
}
