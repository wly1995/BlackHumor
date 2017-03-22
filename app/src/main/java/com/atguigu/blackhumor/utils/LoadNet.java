package com.atguigu.blackhumor.utils;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by 万里洋 on 2017/3/13.
 */

public class LoadNet{
    public static void getDataPost(String url, final LoadNetHttp http) {

        OkHttpUtils.get().url(url).id(100).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                if (http != null) {
                    http.success(response);
                }
            }
        });
    }
}
