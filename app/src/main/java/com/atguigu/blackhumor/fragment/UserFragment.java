package com.atguigu.blackhumor.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.activity.GoodsInfoActivity;
import com.atguigu.blackhumor.adapter.ShopAdapter;
import com.atguigu.blackhumor.bean.GoodsBean;
import com.atguigu.blackhumor.bean.ShopBean;
import com.atguigu.blackhumor.utils.Url;

import java.util.List;

import butterknife.Bind;

/**
 * Created by 万里洋 on 2017/3/28.
 */

public class UserFragment extends BaseFragment {
    public static final String WEBVIEW_BEAN = "webview_bean";
    public static final String GOODS_BEAN = "goods_bean";
    @Bind(R.id.rl_user)
    RecyclerView rlUser;
    private List<ShopBean.ResultBean.RecordsBean> records;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData(String json) {
        processData(json);
    }

    private void processData(String json) {
        ShopBean shopBean = JSON.parseObject(json, ShopBean.class);
//        Toast.makeText(getActivity(), "商城数据解析成功"+shopBean.getResult().getRecords().get(0).getTitle(), Toast.LENGTH_SHORT).show();
        records = shopBean.getResult().getRecords();
        ShopAdapter adapter = new ShopAdapter(getActivity(), records);
        rlUser.setAdapter(adapter);
        //设置布局管理   1表示一行只有一个item
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 1);
        rlUser.setLayoutManager(manager);

        adapter.setOnItemClickListener(new ShopAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                GoodsBean goodsBean = new GoodsBean();
                ShopBean.ResultBean.RecordsBean recordsBean = records.get(position);
                goodsBean.setName(recordsBean.getTitle());
                goodsBean.setCover_price(recordsBean.getSalvePrice()+"");
                goodsBean.setFigure(recordsBean.getImgUrl());
                goodsBean.setProduct_id(recordsBean.getSkuId()+"");

                Intent intent = new Intent(getActivity(), GoodsInfoActivity.class);
                intent.putExtra(GOODS_BEAN, goodsBean);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public int getLayoutid() {
        return R.layout.fragment_user;
    }

    @Override
    public String getChildUrl() {
        return Url.SHOPMALL_URL;
    }
}
