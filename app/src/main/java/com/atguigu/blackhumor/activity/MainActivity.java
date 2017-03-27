package com.atguigu.blackhumor.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.fragment.BaseFragment;
import com.atguigu.blackhumor.sildefragment.CollectionFragment;
import com.atguigu.blackhumor.sildefragment.FavouriteFragment;
import com.atguigu.blackhumor.sildefragment.HistoryFragment;
import com.atguigu.blackhumor.sildefragment.MainFragment;
import com.atguigu.blackhumor.sildefragment.ThemeFragment;
import com.atguigu.blackhumor.sildefragment.ViewFragment;
import com.atguigu.blackhumor.sildefragment.WalletFragment;
import com.atguigu.blackhumor.utils.PreferenceUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String SWITCH_MODE_KEY = "mode_key";
    @Bind(R.id.nav_view)
    NavigationView navView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.fl_main)
    FrameLayout flMain;
    /**
     * 存放fragment的集合
     */
    private List<BaseFragment> fragments;
    /**
     * 添加的fragment在集合中的位置
     */
    private int position;
    /**
     * 缓存的fragment
     */
    private Fragment tempFragment;
    private boolean isNight;

    @Override
    protected void initListener() {
        navView.setNavigationItemSelectedListener(this);
        View headerView = navView.getHeaderView(0);
        ImageView ivMain  = (ImageView) headerView.findViewById(R.id.user_avatar_view);
        ImageView ivSelectMode = (ImageView) headerView.findViewById(R.id.iv_head_switch_mode);
        TextView mUserName = (TextView) headerView.findViewById(R.id.user_name);
        TextView mUserSign = (TextView) headerView.findViewById(R.id.user_other_info);
        //设置用户名 签名
        mUserName.setText(getResources().getText(R.string.hotbitmapgg));
        mUserSign.setText(getResources().getText(R.string.about_user_head_layout));
        ivMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击头像", Toast.LENGTH_SHORT).show();
            }
        });
        boolean flag = PreferenceUtil.getBoolean(SWITCH_MODE_KEY, false);
        if (flag) {
            ivSelectMode.setImageResource(R.drawable.ic_switch_daily);
        } else {
            ivSelectMode.setImageResource(R.drawable.ic_switch_night);
        }
        ivSelectMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                switchNightMode();
                Toast.makeText(MainActivity.this, "模式", Toast.LENGTH_SHORT).show();
            }
        });
        NavigationMenuView childAt = (NavigationMenuView) navView.getChildAt(0);
        childAt.setVerticalScrollBarEnabled(false);
    }

    /**
     * 日夜间模式切换 不会做
     */
    private void switchNightMode() {
//        boolean isNight = PreferenceUtil.getBoolean(SWITCH_MODE_KEY, false);
        int mode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        if (mode == Configuration.UI_MODE_NIGHT_YES) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else if (mode == Configuration.UI_MODE_NIGHT_NO) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        recreate();
    }

    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        fragments.add(new MainFragment());
        fragments.add(new ViewFragment());
        fragments.add(new CollectionFragment());
        fragments.add(new HistoryFragment());
        fragments.add(new FavouriteFragment());
        fragments.add(new WalletFragment());
        fragments.add(new ThemeFragment());
        Fragment baseFragment = fragments.get(0);
        switchFragment(baseFragment);
    }

    @Override
    protected void initTitle() {

    }

    @Override
    public int getLayoutid() {
        return R.layout.silde_layout;
    }

    /**
     * 第一次menu显示的时候调用的
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * 也就是从第二次点击menu按钮显示的时候都会调用这个
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private long time = 0;
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (System.currentTimeMillis() - time > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                time = System.currentTimeMillis();
            } else {
                finish();
            }
        }
    }
    /**
     * 这个是对侧滑中的选择时回调的方法
     *
     * @param item
     * @return
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.main_home) {
            position = 0;
        } else if (id == R.id.main_vip) {
            //大会员
            startActivity(new Intent(MainActivity.this, VipActivity.class));
        } else if (id == R.id.main_integral) {

        } else if (id == R.id.main_cache) {
            // 离线缓存
            startActivity(new Intent(MainActivity.this, OffLineDownloadActivity.class));
        } else if (id == R.id.main_later) {
            position = 1;
        } else if (id == R.id.main_collection) {
            position = 2;
        }else if (id == R.id.main_history) {
            position = 3;
        }else if (id == R.id.main_like) {
            position = 4;
        }else if (id == R.id.main_wallet) {
            position = 5;
        }else if (id == R.id.main_choose) {
            position = 6;
        }else if (id == R.id.setting_help) {

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        //根据对应的位置切换fragment,先获取当前的fragment
        Fragment currentFragment = fragments.get(position);
        switchFragment(currentFragment);
        return true;
    }

    private void switchFragment(Fragment currentFragment) {
        //缓存的和当前的不是一个fragment才去进行切换
        if (tempFragment != currentFragment){
            //得到管理类
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //如果没有添加就先进行添加，指的是没有添加到容器中的意思
            if (!currentFragment.isAdded()){
                //隐藏缓存的fragment
                if (tempFragment!=null){//校验
                    ft.hide(tempFragment);
                }
                //添加
                ft.add(R.id.fl_main,currentFragment,null);
            }else{//如果当前的被添加了就直接显示
                //隐藏缓存
                if (tempFragment!=null){//校验
                    ft.hide(tempFragment);
                }
                //直接显示
                ft.show(currentFragment);
            }
            //进行事务提交
            ft.commit();
            //在这进行缓存（把当前的fragment赋值给缓存）
            tempFragment = currentFragment;
        }
    }
}
