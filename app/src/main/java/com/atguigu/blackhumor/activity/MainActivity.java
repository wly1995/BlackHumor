package com.atguigu.blackhumor.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.fragment.AftersomeFragment;
import com.atguigu.blackhumor.fragment.BaseFragment;
import com.atguigu.blackhumor.fragment.DiscoveryFragment;
import com.atguigu.blackhumor.fragment.PartitionFragment;
import com.atguigu.blackhumor.fragment.RecommendFragment;
import com.atguigu.blackhumor.sildefragment.MainFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    //    @Bind(R.id.tb_main)
//    TabLayout tbMain;
//    @Bind(R.id.vp_main)
//    ViewPager vpMain;
//    @Bind(R.id.iv_home)
//    ImageView ivHome;
//    @Bind(R.id.tv_user)
//    TextView tvUser;
//    @Bind(R.id.tv_login)
//    TextView tvLogin;
//    @Bind(R.id.iv_game)
//    ImageView ivGame;
//    @Bind(R.id.iv_download)
//    ImageView ivDownload;
//    @Bind(R.id.iv_search)
//    ImageView ivSearch;
//    @Bind(R.id.content_main)
//    LinearLayout contentMain;
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

    @Override
    protected void initListener() {
        navView.setNavigationItemSelectedListener(this);
        View headerView = navView.getHeaderView(0);
        ImageView ivMain  = (ImageView) headerView.findViewById(R.id.iv_main);
        TextView tvMain = (TextView) headerView.findViewById(R.id.tv_main);
        ivMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击头像", Toast.LENGTH_SHORT).show();
            }
        });
        tvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击登陆", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        fragments.add(new MainFragment());
        fragments.add(new RecommendFragment());
        fragments.add(new AftersomeFragment());
        fragments.add(new PartitionFragment());
        fragments.add(new DiscoveryFragment());
        fragments.add(new DiscoveryFragment());
        fragments.add(new DiscoveryFragment());
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
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
            // Handle the camera action
//            Toast.makeText(this, "照相机", Toast.LENGTH_SHORT).show();
            position = 0;
        } else if (id == R.id.main_vip) {

        } else if (id == R.id.main_integral) {

        } else if (id == R.id.main_cache) {

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
