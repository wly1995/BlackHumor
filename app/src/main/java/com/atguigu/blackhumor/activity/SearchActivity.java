package com.atguigu.blackhumor.activity;

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
import com.atguigu.blackhumor.adapter.SearchAdapter;
import com.atguigu.blackhumor.fragment.BaseFragment;
import com.atguigu.blackhumor.fragment.ComprehensiveFragment;
import com.atguigu.blackhumor.fragment.UPFragment;
import com.atguigu.blackhumor.fragment.VedioFragment;
import com.atguigu.blackhumor.fragment.afterFragment;
import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.atguigu.blackhumor.R.id.search_edit;

public class SearchActivity extends AppCompatActivity {
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
                Toast.makeText(this, "扫一扫", Toast.LENGTH_SHORT).show();
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
}
