package com.atguigu.blackhumor.fragment;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.adapter.FollowRecycleAdapter;
import com.atguigu.blackhumor.bean.FollowBean;
import com.atguigu.blackhumor.utils.Url;

import butterknife.Bind;

/**
 * Created by 万里洋 on 2017/3/20.
 */

public class AftersomeFragment extends BaseFragment {

    @Bind(R.id.rv_aftersome)
    RecyclerView rvAftersome;
    private FollowRecycleAdapter adapter;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData(String json) {
//        Log.e("TAG","请求成功"+json);
        processData(json);
    }

    @Override
    public int getLayoutid() {
        return R.layout.fragment_aftersome;
    }

    @Override
    public String getChildUrl() {
        return Url.AFTER_SOME_URL;
    }

    private void processData(String json) {
        FollowBean followBean = JSON.parseObject(json, FollowBean.class);
        //解析数据成功后开始设置ReclcyView的适配器
        adapter = new FollowRecycleAdapter(getActivity(), followBean.getResult());
        //设置适配器器
        rvAftersome.setAdapter(adapter);
        //设置布局管理   1表示一行只有一个item
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 1);
        rvAftersome.setLayoutManager(manager);
//        //设置点击事件
//        adapter.setOnItemClickListener(new SynPagerAdapter.OnRecyclerViewItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Toast.makeText(getContext(), "position==" + position, Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
