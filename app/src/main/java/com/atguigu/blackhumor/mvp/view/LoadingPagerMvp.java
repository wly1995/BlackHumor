package com.atguigu.blackhumor.mvp.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.mvp.presenter.LoadingPagerPresenter;
import com.atguigu.blackhumor.utils.UiUtils;


/**
 * Created by 万里洋 on 2017/3/14.
 */

public abstract class LoadingPagerMvp extends FrameLayout implements ILoadingPagerView {
    private final Context context;
    private LayoutParams params;
    private View loadingView;
    private View errorView;
    private View emptyView;
    private View sucessView;
    private LoadingPagerMvp.ResultState resultState;

    private LoadingPagerPresenter loadingPagerPresenter;

    public LoadingPagerMvp(Context context) {
        super(context);
        this.context = context;
        init();
        loadingPagerPresenter = new LoadingPagerPresenter(LoadingPagerMvp.this);
    }

    public LoadingPagerMvp(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    /**
     * 添加布局
     */
    private void init() {
        //设置全屏属性
        params = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        //加载布局
        if (loadingView == null) {
            loadingView = View.inflate(context, R.layout.page_loading, null);
            this.addView(loadingView, params);
        }
        if (errorView == null) {
            errorView = View.inflate(context, R.layout.page_error, null);
            this.addView(errorView, params);
            errorView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadData();
                }
            });
        }
        if (emptyView == null) {
            emptyView = View.inflate(context, R.layout.page_empty, null);
            this.addView(emptyView, params);
        }


        //展示布局
        showSafeView();
    }

    private void showSafeView() {
        //展示view保证在主线程
        UiUtils.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showView();
            }
        });
    }

    /*
   *
   * 根据状态来展示不同的页面
   * */
    private void showView() {
        //是否展示错误页面
        errorView.setVisibility(
                current_state == STATE_ERROR ? View.VISIBLE : View.INVISIBLE);
        //是否展示加载界面
        loadingView.setVisibility(
                current_state == STATE_LOADING ? View.VISIBLE : View.INVISIBLE);
        //是否展示空页面
        emptyView.setVisibility(
                current_state == STATE_EMPTY ? View.VISIBLE : View.INVISIBLE);

        if (sucessView == null) {
            sucessView = View.inflate(context, getViewId(), null);
            this.addView(sucessView, params);
        }
        //是否展示成功页面
        sucessView.setVisibility(
                current_state == STATE_SUCCESS ? View.VISIBLE : View.INVISIBLE);
    }



    /*
    * 根据不同的网络状态加载相应的页面
    *
    * */
    public void loadData() {
        //加载网络
        String url = url();
        //如果url为空表示不进行网络请求
        if (TextUtils.isEmpty(url)) {
            resultState = LoadingPagerMvp.ResultState.SUCCESS;
            loadImage();
            return;
        }else{
            loadingPagerPresenter.getDataFromData();
        }
    }

    private void loadImage() {
        switch (resultState) {
            case ERROR:
                current_state = STATE_ERROR; //根据枚举值来赋值相应的状态
                break;
            case EMPTY:
                current_state = STATE_EMPTY; //根据枚举值来赋值相应的状态
                break;
            case SUCCESS:
                current_state = STATE_SUCCESS; //根据枚举值来赋值相应的状态
                break;
        }

        showSafeView();
        if (current_state == STATE_SUCCESS) {
            //把数据传过去
            onSuccess(resultState, sucessView);
        }
    }
    //成功的到json数据的方法
    public void getJson(String content){
        if (TextUtils.isEmpty(content)){
            //current_state = STATE_EMPTY;
            resultState = ResultState.EMPTY;
            resultState.setJson("");
        }else{
            resultState = ResultState.SUCCESS;
            resultState.setJson(content);
        }
        loadImage();
    }
    //失败的时候调用的
    public void onFail(Exception e){
        resultState = ResultState.ERROR;
        resultState.setJson(e.getMessage());
        loadImage();
    }

    protected abstract void onSuccess(LoadingPagerMvp.ResultState resultState, View sucessView);

    @Override
    public String url() {
        return getUrl();
    }

    public enum ResultState {
        //相当于是三个ResultState对象
        ERROR(2), SUCCESS(3), EMPTY(4);
        private int state;

        ResultState(int state) {
            this.state = state;
        }

        private String json;

        public void setJson(String json) {
            this.json = json;
        }

        public String getJson() {
            return json;
        }

    }

    public abstract String getUrl();

    public abstract int getViewId();

    private int STATE_LOADING = 1; //加载中
    private int STATE_ERROR = 2; //加载失败
    private int STATE_SUCCESS = 3; //加载成功
    private int STATE_EMPTY = 4; //空

    private int current_state = STATE_LOADING;
}
