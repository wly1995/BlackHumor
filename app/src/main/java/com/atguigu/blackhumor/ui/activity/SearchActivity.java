package com.atguigu.blackhumor.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.ui.adapter.SearchAdapter;
import com.atguigu.blackhumor.ui.activity.fragment.BaseFragment;
import com.atguigu.blackhumor.ui.activity.fragment.ComprehensiveFragment;
import com.atguigu.blackhumor.ui.activity.fragment.UPFragment;
import com.atguigu.blackhumor.ui.activity.fragment.VedioFragment;
import com.atguigu.blackhumor.ui.activity.fragment.afterFragment;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.atguigu.blackhumor.R.id.search_edit;

public class SearchActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 5;
    @Bind(R.id.search_scan)
    ImageView searchScan;
    @Bind(search_edit)
    TextView searchEdit;
    @Bind(R.id.tab_search)
    TabLayout tabSearch;
    @Bind(R.id.vp_search)
    ViewPager vpSearch;
    @Bind(R.id.search_back)
    ImageView searchBack;
    SearchFragment searchFragment = SearchFragment.newInstance();
    private String content;
    private List<BaseFragment> fragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        getData();
        initFragment();
        SearchAdapter adapter = new SearchAdapter(getSupportFragmentManager(),fragments);
        vpSearch.setAdapter(adapter);
        tabSearch.setupWithViewPager(vpSearch);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ComprehensiveFragment(content));
        fragments.add(new afterFragment());
        fragments.add(new UPFragment());
        fragments.add(new VedioFragment());
    }

    private void getData() {
        content = getIntent().getStringExtra("content");
        searchEdit.setText(content);
    }

    @OnClick({R.id.search_back, R.id.search_scan, search_edit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_back:
                finish();
                break;
            case R.id.search_scan:
//                Toast.makeText(this, "扫一扫", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case search_edit:
                searchFragment.setOnSearchClickListener(new IOnSearchClickListener() {
                    @Override
                    public void OnSearchClick(String keyword) {
//                        Toast.makeText(this, keyword,Toast.LENGTH_SHORT).show();
                    }
                });
                searchFragment.show(getSupportFragmentManager(),SearchFragment.TAG);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
