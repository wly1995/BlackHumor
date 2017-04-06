package com.atguigu.blackhumor.mvp.model.RxUtils;


import android.util.Log;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by 万里洋 on 2017/4/6.
 * 创建Rx的工具类来封装联网请求的方法
 */

public class RxUtil {
    public static Observable<String> Load(final String url){
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    OkHttpUtils.get().url(url).id(100).build().execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            Log.e("TAG", e.getMessage() + "_onFailure-" + Thread.currentThread().getName());
                        }
                        @Override
                        public void onResponse(String response, int id) {
                            subscriber.onNext(response);
                            subscriber.onCompleted();
                        }
                    });
                }
            }
        });
    }
}
