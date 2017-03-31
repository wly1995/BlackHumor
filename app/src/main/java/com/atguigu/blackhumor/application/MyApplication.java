package com.atguigu.blackhumor.application;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;

import com.anye.greendao.gen.DaoMaster;
import com.anye.greendao.gen.DaoSession;
import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.utils.ThemeHelper;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by 万里洋 on 2017/3/22.
 */

public class MyApplication extends Application implements ThemeUtils.switchColor{
    private static Context context;
    private static Thread mainThread;
    private static int  threadid;
    private static Handler handler;
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    public static MyApplication instances;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        threadid = android.os.Process.myPid();
        handler = new Handler();
        //初始化未捕获异常 上线的时候才打开
        //CrashHandler.getInstance().init();
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        ZXingLibrary.initDisplayOpinion(this);
        //初始化greenDao
        instances = this;
        setDatabase();
        //初始化皮肤
        ThemeUtils.setSwitchColor(this);
        //初始化推送
        JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);// 初始化 JPush
        //初始化ShareSDK
    }

    /**
     * 设置greenDao
     */
    private void setDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        mHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }
    public DaoSession getDaoSession() {
        return mDaoSession;
    }
    public SQLiteDatabase getDb() {
        return db;
    }

    public static Context getContext() {
        return context;
    }
    public static MyApplication getInstances(){
        return instances;
    }

    public static Thread getMainThread() {
        return mainThread;
    }

    public static int getThreadid() {
        return threadid;
    }

    public static Handler getHandler() {
        return handler;
    }

    /*
    * 1、onCreate（） 在创建应用程序时创建
      2、onTerminate（） 在模拟环境下执行。当终止应用程序对象时调用，不保证一定被调用，
      当程序是被内核终止以便为其他应用程序释放资源，
      那么将不会提醒，并且不调用应用程序的对象的onTerminate方法而直接终止进程。
    3、onLowMemory（） 低内存时执行。
    好的应用程序一般会在这个方法里面释放一些不必要的资源来应付当后台程序已经终止，
    前台应用程序内存还不够时的情况。
    4、onConfigurationChanged（Configuration newConfig） 配置改变时触发这个方法。
    5、onTrimMemory（int level）程序在进行内存清理时执行​
    *
    *
    * */


    @Override
    public int replaceColorById(Context context, @ColorRes int colorId) {
        if (ThemeHelper.isDefaultTheme(context)) {
            return context.getResources().getColor(colorId);
        }
        String theme = getTheme(context);
        if (theme != null) {
            colorId = getThemeColorId(context, colorId, theme);
        }
        return context.getResources().getColor(colorId);
    }

    @Override
    public int replaceColor(Context context, @ColorInt int originColor) {
        if (ThemeHelper.isDefaultTheme(context)) {
            return originColor;
        }
        String theme = getTheme(context);
        int colorId = -1;

        if (theme != null) {
            colorId = getThemeColor(context, originColor, theme);
        }
        return colorId != -1 ? getResources().getColor(colorId) : originColor;
    }

    private String getTheme(Context context) {
        if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_STORM) {
            return "blue";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_HOPE) {
            return "purple";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_WOOD) {
            return "green";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_LIGHT) {
            return "green_light";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_THUNDER) {
            return "yellow";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_SAND) {
            return "orange";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_FIREY) {
            return "red";
        }
        return null;
    }

    private
    @ColorRes
    int getThemeColorId(Context context, int colorId, String theme) {
        switch (colorId) {
            case R.color.theme_color_primary:
                return context.getResources().getIdentifier(theme, "color", getPackageName());
            case R.color.theme_color_primary_dark:
                return context.getResources().getIdentifier(theme + "_dark", "color", getPackageName());
            case R.color.theme_color_primary_trans:
                return context.getResources().getIdentifier(theme + "_trans", "color", getPackageName());
        }
        return colorId;
    }

    private
    @ColorRes
    int getThemeColor(Context context, int color, String theme) {
        switch (color) {
            case 0xfffb7299:
                return context.getResources().getIdentifier(theme, "color", getPackageName());
            case 0xffb85671:
                return context.getResources().getIdentifier(theme + "_dark", "color", getPackageName());
            case 0x99f0486c:
                return context.getResources().getIdentifier(theme + "_trans", "color", getPackageName());
        }
        return -1;
    }
}
