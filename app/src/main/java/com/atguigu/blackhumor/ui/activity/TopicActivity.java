package com.atguigu.blackhumor.ui.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.ui.adapter.TopicAdapter;
import com.atguigu.blackhumor.service.entity.TopicBean;
import com.atguigu.blackhumor.utils.Url;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import okhttp3.Call;

public class TopicActivity extends BaseActivity {
    @Bind(R.id.ib_back)
    ImageButton ibBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.ib_more)
    ImageButton ibMore;
    @Bind(R.id.lv_topic)
    ListView lvTopic;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        getDataFromNet();
    }

    private void getDataFromNet() {
        OkHttpUtils.get().url(Url.TOPIC_URL).id(100).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                Log.e("TAG", "onResponse: " + response);
                processData(response);
            }
        });
    }

    private void processData(String response) {
        TopicBean topicBean = JSON.parseObject(response, TopicBean.class);
//        Log.e("TAG", "processData: "+topicBean.getList().get(1).getTitle());
        final List<TopicBean.ListBean> list = topicBean.getList();
        TopicAdapter adapter = new TopicAdapter(list,this);
        lvTopic.setAdapter(adapter);
        //设置点击事件
        lvTopic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TopicBean.ListBean listBean = list.get(position);
                Intent intent = new Intent(TopicActivity.this, TopicWebActivity.class);
                intent.putExtra("key",listBean);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initTitle() {
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ibMore.setVisibility(View.INVISIBLE);
        tvTitle.setText("话题中心");
        tvTitle.setTextSize(15);
    }

    @Override
    public int getLayoutid() {
        return R.layout.activity_topic;
    }
}
