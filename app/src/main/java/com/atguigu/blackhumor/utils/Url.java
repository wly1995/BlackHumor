package com.atguigu.blackhumor.utils;

/**
 * Created by 万里洋 on 2017/3/21.
 */

public class Url {
    public static String BASE_URL = "http://live.bilibili.com/AppNewIndex/";


    public static String LIVE_URL = BASE_URL+"common?_device=android&appkey=1d8b6e7d45233436&build=501000&mobi_app=android&" +
                                    "platform=android&scale=hdpi&ts=1490013188000&sign=92541a11ed62841120e786e637b9db3b";

    public static String RECOMMEND_URL = "http://app.bilibili.com/x/feed/index?appkey=1d8b6e7d45233436&build=501000&idx=1490013261&mobi_app=android&network=wifi&platform=android&pull=true&style=2&ts=1490015599000\n" +
            "&sign=af4edc66aef7e443c98c28de2b660aa4";

    public static String AFTER_SOME_URL = "http://bangumi.bilibili.com/api/app_index_page_v4?build=3940&device=phone&mobi_app=iphone&platform=ios";

    public static String FIND_URL = "http://app.bilibili.com/x/v2/search/hot?appkey=1d8b6e7d45233436&build=501000&limit=50&mobi_app=android&platform=android&ts=1490014710000&sign=e5ddf94fa9a0d6876cb85756c37c4adc";
}
