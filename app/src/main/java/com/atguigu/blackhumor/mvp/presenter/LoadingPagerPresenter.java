package com.atguigu.blackhumor.mvp.presenter;

import android.util.Log;

import com.atguigu.blackhumor.mvp.model.ILoadingPagerModel;
import com.atguigu.blackhumor.mvp.model.LoadingPagerModel;
import com.atguigu.blackhumor.mvp.model.OnRequestListener;
import com.atguigu.blackhumor.mvp.view.LoadingPagerMvp;

/**
 * Created by 万里洋 on 2017/4/6.
 */

public class LoadingPagerPresenter implements ILoadingpager {
    /**
     * MVP设计模式中-M
     */
    private ILoadingPagerModel iLoadingPagerModel;
    /**
     * MVP设计模式中-V
     */
    private LoadingPagerMvp iLoadingPagerView;

    public LoadingPagerPresenter(LoadingPagerMvp loadingPagerMvp){
        this.iLoadingPagerView = loadingPagerMvp;
        this.iLoadingPagerModel = new LoadingPagerModel();
    }
    @Override
    public void getDataFromData() {
        //在m层进行真正的联网请求
        iLoadingPagerModel.getDataFromNet(iLoadingPagerView.url(), new OnRequestListener() {
            @Override
            public void onSuccess(String result) {
                Log.e("onSuccess",result);
                iLoadingPagerView.getJson(result);
            }

            @Override
            public void onFailed(Exception e) {
                iLoadingPagerView.onFail(e);
            }
        });
    }
}
