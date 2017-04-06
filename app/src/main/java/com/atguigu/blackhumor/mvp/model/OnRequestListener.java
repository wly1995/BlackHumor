package com.atguigu.blackhumor.mvp.model;

/**
 * Created by 万里洋 on 2017/4/6.
 */

public interface OnRequestListener {
    /**
     * 当请求成功的时候回调
     * @param result
     */
    void onSuccess(String result);

    /**
     * 当失败的时候回调
     */
    void onFailed(Exception e);
}
