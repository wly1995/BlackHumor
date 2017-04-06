package com.atguigu.blackhumor.mvp.view.fragment;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.adapter.PartAdapter;
import com.atguigu.blackhumor.bean.PartBean;
import com.atguigu.blackhumor.utils.Url;

import butterknife.Bind;

/**
 * Created by 万里洋 on 2017/3/20.
 */

public class PartitionFragment extends BaseFragment {

    @Bind(R.id.rv_part)
    RecyclerView rvPart;
    @Bind(R.id.part_refresh)
    SwipeRefreshLayout partRefresh;

    @Override
    protected void initListener() {
        partRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getLoadingPager().loadData();
            }
        });
    }

    @Override
    protected void initData(String json) {
        processData(json);
        partRefresh.setRefreshing(false);
    }

    @Override
    public int getLayoutid() {
        return R.layout.fragment_partition;
    }

    @Override
    public String getChildUrl() {
        return Url.PART_URL;
    }

    private void processData(String json) {
        PartBean partBean = JSON.parseObject(json, PartBean.class);


        PartAdapter adapter = new PartAdapter(getActivity(), partBean.getData());

        //设置适配器
        rvPart.setAdapter(adapter);
        //设置布局管理   1表示一行只有一个item
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 1);
        rvPart.setLayoutManager(manager);
    }
}
