package com.atguigu.blackhumor.mvp.view.pager;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.mvp.view.activity.VideoDetailsActivity;
import com.atguigu.blackhumor.adapter.SynPagerAdapter;
import com.atguigu.blackhumor.bean.RecommendBean;
import com.atguigu.blackhumor.utils.Url;
import com.atguigu.blackhumor.view.LoadingPager;

/**
 * Created by 万里洋 on 2017/3/22.
 *
 */

public class DyncPager extends LoadingPager {


    private final Context mContext;

    private SwipeRefreshLayout synRefresh;
    private RecyclerView recyclerView;

    public DyncPager(Context context) {
        super(context);
        this.mContext = context;
        loadData();
    }


    @Override
    protected void onSuccess(ResultState resultState, View sucessView) {
        recyclerView = (RecyclerView) sucessView.findViewById(R.id.rv_syn);
        synRefresh = (SwipeRefreshLayout) sucessView.findViewById(R.id.syn_refresh);
        initData(resultState.getJson());
        initListener();
    }

    private void initListener() {
        synRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });
    }

    private void initData(String json) {
//        Log.e("TAG", "请求成功哈哈: ");
        processData(json);
        synRefresh.setRefreshing(false);
    }

    private void processData(String json) {
        final RecommendBean recommendBean = JSON.parseObject(json, RecommendBean.class);
//        Log.e("TAG",recommendBean.getData().get(0).getTitle());
        SynPagerAdapter adapter = new SynPagerAdapter(mContext, recommendBean);
        recyclerView.setAdapter(adapter);
        //设置布局管理   1表示一行只有一个item
        GridLayoutManager manager = new GridLayoutManager(mContext, 2);
        recyclerView.setLayoutManager(manager);
        //设置点击事件
        adapter.setOnItemClickListener(new SynPagerAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Toast.makeText(mContext, "position==" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, VideoDetailsActivity.class);
                intent.putExtra("video",recommendBean.getData().get(position));
                mContext.startActivity(intent);
            }
        });
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
