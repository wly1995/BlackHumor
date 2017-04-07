package com.atguigu.blackhumor.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.atguigu.blackhumor.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewsDetailActivity extends AppCompatActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.ib_menu)
    ImageButton ibMenu;
    @Bind(R.id.ib_back)
    ImageButton ibBack;
    @Bind(R.id.ib_textsize)
    ImageButton ibTextsize;
    @Bind(R.id.ib_share)
    ImageButton ibShare;
    @Bind(R.id.webview)
    WebView webview;
    @Bind(R.id.progressbar)
    ProgressBar progressbar;
    private String url;
    /**
     * 缓存
     */
    private int tempSize = 2;

    /**
     * 真正的字体大小
     */
    private int realSize = tempSize;
    private WebSettings webSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        ButterKnife.bind(this);
        url = getIntent().getStringExtra("url");
        tvTitle.setVisibility(View.GONE);
        ibBack.setVisibility(View.VISIBLE);
        ibTextsize.setVisibility(View.VISIBLE);
        ibShare.setVisibility(View.VISIBLE);

        //WebView的使用
        webview.loadUrl(url);
        //设置webview的对象，用来对webview进行设置
        webSettings = webview.getSettings();
        //支持javaScript脚步语言
        webSettings.setJavaScriptEnabled(true);
        //添加缩放按钮-页面要支持
        webSettings.setBuiltInZoomControls(true);
        //支持双击变大变小-页面支持
        webSettings.setUseWideViewPort(true);
        //设置监听，设置一个webview的客户端
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                 super.onPageFinished(view, url);
                 progressbar.setVisibility(View.GONE);
             }
        });
    }

    @OnClick({R.id.ib_back, R.id.ib_textsize})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_back:
                finish();
                break;
            case R.id.ib_textsize:
                showChangeTextSizeDialog();
                break;
       }
    }

    private void showChangeTextSizeDialog() {
        Log.e("TAG","meme");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("设置文字大小");
        String[] items = {"超大字体", "大字体", "正常字体", "小字体", "超小字体"};
        builder.setSingleChoiceItems(items, realSize, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //先把选择的字体大小给缓存的,意思即是记录你上次的选择
                tempSize = which;
            }
        });
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //在把缓存的给真正的字体的大小
                realSize = tempSize;
                //这个方法是选择字体大小
                changeTextSize(realSize);
            }
        });
        builder.show();
    }

    private void changeTextSize(int realSize) {
        switch (realSize) {
            case 0:
                webSettings.setTextZoom(200);
                break;
            case 1:
                webSettings.setTextZoom(150);
                break;
            case 2:
                webSettings.setTextZoom(100);
                break;
            case 3:
                webSettings.setTextZoom(75);
                break;
            case 4:
                webSettings.setTextZoom(50);
                break;
        }
    }
}
