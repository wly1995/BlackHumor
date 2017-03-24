package com.atguigu.blackhumor.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.adapter.OriginPagerAdapter;
import com.atguigu.blackhumor.bean.RankBean;
import com.atguigu.blackhumor.utils.Url;

import butterknife.Bind;

/**
 * Created by 万里洋 on 2017/3/24.
 */

public class OriginFragment extends BaseFragment {

    @Bind(R.id.rv_syn)
    RecyclerView rvSyn;
    @Bind(R.id.syn_refresh)
    SwipeRefreshLayout synRefresh;
    private OriginPagerAdapter adapter;

    @Override
    protected void initListener() {
        synRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getLoadingPager().loadData();
            }
        });
    }

    @Override
    protected void initData(String json) {
        processData(json);
        synRefresh.setRefreshing(false);
    }

    @Override
    public int getLayoutid() {
        return R.layout.fragment_syn;
    }

    @Override
    public String getChildUrl() {
        return Url.ORIGIN_URL;
    }

    private void processData(String json) {
        RankBean rankBean = JSON.parseObject(json, RankBean.class);
        adapter = new OriginPagerAdapter(getActivity(),rankBean);
        rvSyn.setAdapter(adapter);
        //设置布局管理   1表示一行只有一个item
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 1);
        rvSyn.setLayoutManager(manager);
        adapter.setOnItemClickListener(new OriginPagerAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), "position=="+position , Toast.LENGTH_SHORT).show();
            }
        });
    }

}
