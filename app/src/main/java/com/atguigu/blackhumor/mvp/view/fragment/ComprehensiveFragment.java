package com.atguigu.blackhumor.mvp.view.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.adapter.ComprehensiveAdapter;
import com.atguigu.blackhumor.bean.SearchBean;
import com.atguigu.blackhumor.utils.Url;

import butterknife.Bind;

/**
 * Created by 万里洋 on 2017/3/27.
 */

public class ComprehensiveFragment extends BaseFragment {
    private final String content;
    @Bind(R.id.rl_conprehensive)
    RecyclerView rlConprehensive;
    @Bind(R.id.conprehensive_refresh)
    SwipeRefreshLayout conprehensiveRefresh;

    public ComprehensiveFragment(String content) {
        this.content = content;
    }

    @Override
    protected void initListener() {
        conprehensiveRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getLoadingPager().loadData();
            }
        });
    }

    @Override
    protected void initData(String json) {
//        Toast.makeText(getActivity(), ""+json, Toast.LENGTH_SHORT).show();
        processData(json);
        conprehensiveRefresh.setRefreshing(false);
    }

    private void processData(String json) {
        SearchBean searchBean = JSON.parseObject(json, SearchBean.class);
        SearchBean.DataBean.ItemsBean items = searchBean.getData().getItems();
        ComprehensiveAdapter adapter = new ComprehensiveAdapter(getActivity(),items);
        //设置适配器器
        rlConprehensive.setAdapter(adapter);
        //设置布局管理   1表示一行只有一个item
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 1);
        rlConprehensive.setLayoutManager(manager);
        //设置点击事件
        adapter.setOnItemClickListener(new ComprehensiveAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), "position=="+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getLayoutid() {
        return R.layout.fragment_conprehensive;
    }

    @Override
    public String getChildUrl() {
        return Url.SEARCH_URL + content + Url.SEARCH_URL_END;
    }
}
