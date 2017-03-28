package com.atguigu.blackhumor.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.adapter.RankAdapter;
import com.atguigu.blackhumor.fragment.BaseFragment;
import com.atguigu.blackhumor.fragment.OriginFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class OriginalActivity extends BaseActivity {

    @Bind(R.id.iv_home)
    ImageView ivHome;
    @Bind(R.id.iv_user)
    ImageView tvUser;
    @Bind(R.id.tv_login)
    TextView tvLogin;
    @Bind(R.id.iv_game)
    ImageView ivGame;
    @Bind(R.id.iv_download)
    ImageView ivDownload;
    @Bind(R.id.iv_search)
    ImageView ivSearch;
    @Bind(R.id.tb_main)
    TabLayout tbMain;
    @Bind(R.id.vp_main)
    ViewPager vpMain;
    @Bind(R.id.rl_user)
    RelativeLayout rlUser;
    @Bind(R.id.content_main)
    LinearLayout contentMain;

    String[] titles = {"原创", "全站", "番剧"};
    private List<BaseFragment> fragments;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        initFragment();
        RankAdapter adapter = new RankAdapter(getSupportFragmentManager(),fragments);
        vpMain.setAdapter(adapter);
        tbMain.setupWithViewPager(vpMain);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new OriginFragment());
        fragments.add(new OriginFragment());
        fragments.add(new OriginFragment());
    }

    @Override
    protected void initTitle() {
        ivGame.setVisibility(View.GONE);
        rlUser.setVisibility(View.GONE);
        tvLogin.setText("排行榜");
        ivHome.setImageResource(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
    }

    @Override
    public int getLayoutid() {
        return R.layout.activity_original;
    }

    @OnClick({R.id.iv_home, R.id.iv_download, R.id.iv_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_home:
                finish();
                break;
            case R.id.iv_download:
                Toast.makeText(this, "下载", Toast.LENGTH_SHORT).show();
               break;
            case R.id.iv_search:
                Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
