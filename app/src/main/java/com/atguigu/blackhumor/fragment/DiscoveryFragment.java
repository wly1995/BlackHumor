package com.atguigu.blackhumor.fragment;


import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.activity.BuyActivity;
import com.atguigu.blackhumor.activity.OriginalActivity;
import com.atguigu.blackhumor.activity.SearchActivity;
import com.atguigu.blackhumor.activity.TopicActivity;
import com.atguigu.blackhumor.bean.FindBean;
import com.atguigu.blackhumor.utils.Url;
import com.github.hymanme.tagflowlayout.OnTagClickListener;
import com.github.hymanme.tagflowlayout.TagAdapter;
import com.github.hymanme.tagflowlayout.TagFlowLayout;
import com.github.hymanme.tagflowlayout.tags.ColorfulTagView;
import com.github.hymanme.tagflowlayout.tags.DefaultTagView;
import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by 万里洋 on 2017/3/20.
 */

public class DiscoveryFragment extends BaseFragment {

    @Bind(R.id.tv_search)
    TextView tvSearch;
    @Bind(R.id.tag_flow_layout)
    TagFlowLayout tagFlowLayout;
    @Bind(R.id.ll_like)
    LinearLayout llLike;
    @Bind(R.id.ll_center)
    LinearLayout llCenter;
    @Bind(R.id.ll_activity)
    LinearLayout llActivity;
    @Bind(R.id.ll_balckhome)
    LinearLayout llBalckhome;
    @Bind(R.id.ll_rank)
    LinearLayout llRank;
    @Bind(R.id.ll_all)
    LinearLayout llAll;
    @Bind(R.id.ll_game)
    LinearLayout llGame;
    @Bind(R.id.ll_shop)
    LinearLayout llShop;
    @Bind(R.id.ll_flow)
    LinearLayout llFlow;
    private FindBean findBean;

    @Override
    protected void initListener() {
        tagFlowLayout.setTitle("大家都在搜");
        tagFlowLayout.setTitleTextColor(getResources().getColor(R.color.pink_30));
        tagFlowLayout.setTitleTextSize(14);
        //最小显示高度(单位dp)
        tagFlowLayout.setMinVisibleHeight(100);
        //最大显示高度(单位dp)
        tagFlowLayout.setMaxVisibleHeight(300);
        tagFlowLayout.setAnimationDuration(600);
        //设置背景颜色
        tagFlowLayout.setBackGroundColor(getResources().getColor(R.color.primary_text));


    }

    @Override
    protected void initData(String json) {
        processData(json);
    }

    @Override
    public int getLayoutid() {
        return R.layout.fragment_discovery;
    }

    @Override
    public String getChildUrl() {
        return Url.FIND_URL;
    }

    private void processData(String response) {
        findBean = JSON.parseObject(response, FindBean.class);
        //设置adapter
        MyTagAdapter tagAdapter = new MyTagAdapter();
        tagFlowLayout.setTagAdapter(tagAdapter);
        List<FindBean.DataBean.ListBean> list = findBean.getData().getList();
        //给adapter绑定数据
        tagAdapter.addAllTags(list);
        tagFlowLayout.setTagListener(new OnTagClickListener() {
            @Override
            public void onClick(TagFlowLayout parent, View view, int position) {
//                Toast.makeText(getActivity(), "click==" + ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                intent.putExtra("content",((TextView) view).getText());
                getActivity().startActivity(intent);
            }

            @Override
            public void onLongClick(TagFlowLayout parent, View view, int position) {

            }
        });

    }

    class MyTagAdapter extends TagAdapter<FindBean.DataBean.ListBean> {

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //定制tag的样式，包括背景颜色，点击时背景颜色，背景形状等
            DefaultTagView textView = new ColorfulTagView(getActivity());
            textView.setText(((FindBean.DataBean.ListBean) getItem(position)).getKeyword());
            return textView;
        }
    }
    SearchFragment searchFragment = SearchFragment.newInstance();
    @OnClick({R.id.tv_search, R.id.ll_like, R.id.ll_center, R.id.ll_activity, R.id.ll_balckhome,
            R.id.ll_rank, R.id.ll_all, R.id.ll_game, R.id.ll_shop})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_search:
                searchFragment.setOnSearchClickListener(new IOnSearchClickListener() {
                    @Override
                    public void OnSearchClick(String keyword) {
                        Toast.makeText(getActivity(), ""+keyword, Toast.LENGTH_SHORT).show();
                    }
                });
                searchFragment.show(getFragmentManager(),SearchFragment.TAG);
                break;
            case R.id.ll_like:
                Toast.makeText(getActivity(), "兴趣圈", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_center:
                getActivity().startActivity(new Intent(getActivity(),TopicActivity.class));
                break;
            case R.id.ll_activity:
                getActivity().startActivity(new Intent(getActivity(),TopicActivity.class));
                break;
            case R.id.ll_balckhome:
                Toast.makeText(getActivity(), "小黑屋", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_rank:
                getActivity().startActivity(new Intent(getActivity(),OriginalActivity.class));
                break;
            case R.id.ll_all:
                getActivity().startActivity(new Intent(getActivity(),OriginalActivity.class));
                break;
            case R.id.ll_game:
                Toast.makeText(getActivity(), "游戏中心", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_shop:
                getActivity().startActivity(new Intent(getActivity(),BuyActivity.class));
//                Toast.makeText(getActivity(), "周边商城", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
