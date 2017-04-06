package com.atguigu.blackhumor.mvp.view.fragment;

import android.os.Build;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.atguigu.blackhumor.R;

import butterknife.Bind;

/**
 * Created by 万里洋 on 2017/3/28.
 */

public class HomeFragment extends BaseFragment {
    @Bind(R.id.webview)
    WebView webview;
    @Bind(R.id.progressbar)
    ProgressBar progressbar;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData(String json) {
        WebSettings webSettings = webview.getSettings();
        //启用 WebView 中的 Javascript 支持
        webSettings.setJavaScriptEnabled(true);
        //将图片调整到适合webview的大小
        webSettings.setUseWideViewPort(true);

        //设置检索缓存的
        webSettings.setCacheMode(webSettings.LOAD_CACHE_ELSE_NETWORK);
        //1.添加js接口,支持java和js之间的互相调用
        //2.写一个类里面写一个js调java的方法，注意这个方法名和参数类型要和js中的一样，否则无法调用
//        webview.addJavascriptInterface(new myJavaScriptInterface(),"cyc");

        //设置不跳转到系统的浏览器

        webview.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.loadUrl(request.getUrl().toString());
                }
                return true;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }

            /**
             *
             * @param view
             * @param url
             */
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressbar.setVisibility(View.GONE);
            }
        });

        webview.loadUrl("http://bmall.bilibili.com");
    }

    @Override
    public int getLayoutid() {
        return R.layout.fragment_home;
    }

    @Override
    public String getChildUrl() {
        return null;
    }
}
