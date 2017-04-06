package com.atguigu.blackhumor.mvp.model;

/**
 * Created by 万里洋 on 2017/4/6.
 */

public interface ILoadingPagerModel {
    void getDataFromNet(String url,OnRequestListener listener);
}
