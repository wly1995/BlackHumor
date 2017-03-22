package com.atguigu.blackhumor.pager;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.adapter.SynPagerAdapter;
import com.atguigu.blackhumor.bean.RecommendBean;
import com.atguigu.blackhumor.utils.Url;
import com.atguigu.blackhumor.view.LoadingPager;

/**
 * Created by 万里洋 on 2017/3/22.
 */

public class SynPager extends LoadingPager {
    private final Context mContext;
    private RecyclerView recyclerView;

    public SynPager(Context context) {
        super(context);
        this.mContext = context;
        loadData();
    }


    @Override
    protected void onSuccess(ResultState resultState, View sucessView) {
        recyclerView = (RecyclerView) sucessView.findViewById(R.id.rv_syn);
        initData(resultState.getJson());
        initListener();
    }

    private void initListener() {

    }

    private void initData(String json) {
        Log.e("TAG", "请求成功哈哈: ");
        processData(json);
    }

    private void processData(String json) {
        RecommendBean recommendBean = JSON.parseObject(json, RecommendBean.class);
//        Log.e("TAG",recommendBean.getData().get(0).getTitle());
        SynPagerAdapter adapter = new SynPagerAdapter(mContext,recommendBean);
        recyclerView.setAdapter(adapter);
        //设置布局管理   1表示一行只有一个item
        GridLayoutManager manager = new GridLayoutManager(mContext, 2);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected String getUrl() {
        return Url.RECOMMEND_URL;
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_syn;
    }
}
