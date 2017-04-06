package com.atguigu.blackhumor.mvp.view.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.webkit.WebView;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.utils.SystemBarHelper;
import com.bilibili.magicasakura.widgets.TintToolbar;

import butterknife.Bind;

public class VipActivity extends BaseActivity {

    @Bind(R.id.webView)
    WebView webView;
    @Bind(R.id.toolbar)
    TintToolbar mToolbar;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        webView.loadUrl("http://vip.bilibili.com/site/vip-faq-h5.html#yv1");
    }

    @Override
    protected void initTitle() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        //设置StatusBar透明
        SystemBarHelper.immersiveStatusBar(this);
        SystemBarHelper.setHeightAndPadding(this, mToolbar);
    }

    @Override
    public int getLayoutid() {
        return R.layout.activity_vip;
    }

}
