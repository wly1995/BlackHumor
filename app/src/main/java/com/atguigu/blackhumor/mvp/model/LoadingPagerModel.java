package com.atguigu.blackhumor.mvp.model;

import android.util.Log;

import com.atguigu.blackhumor.mvp.model.RxUtils.RxUtil;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 万里洋 on 2017/4/6.
 *
 */

public class LoadingPagerModel implements ILoadingPagerModel {

    @Override
    public void getDataFromNet(String url, final OnRequestListener listener) {
        RxUtil.Load(url)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        Log.e("TAG","onCompleted");
                    }
                    @Override
                    public void onError(Throwable e) {
                        listener.onFailed((Exception) e);
                    }
                    @Override
                    public void onNext(String s) {
                        listener.onSuccess(s);
                    }
                });
    }
}
