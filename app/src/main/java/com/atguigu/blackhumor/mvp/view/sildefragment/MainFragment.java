package com.atguigu.blackhumor.mvp.view.sildefragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anye.greendao.gen.UserDao;
import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.mvp.view.activity.DownLoadActivity;
import com.atguigu.blackhumor.mvp.view.activity.LoginActivity;
import com.atguigu.blackhumor.mvp.view.activity.MainActivity;
import com.atguigu.blackhumor.adapter.ViewPagerAdapter;
import com.atguigu.blackhumor.application.MyApplication;
import com.atguigu.blackhumor.bean.User;
import com.atguigu.blackhumor.mvp.view.fragment.AftersomeFragment;
import com.atguigu.blackhumor.mvp.view.fragment.BaseFragment;
import com.atguigu.blackhumor.mvp.view.fragment.DiscoveryFragment;
import com.atguigu.blackhumor.mvp.view.fragment.LiveFragment;
import com.atguigu.blackhumor.mvp.view.fragment.PartitionFragment;
import com.atguigu.blackhumor.mvp.view.fragment.RecommendFragment;
import com.atguigu.blackhumor.utils.BitmapUtils;
import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by 万里洋 on 2017/3/21.
 */

public class MainFragment extends BaseFragment {
    @Bind(R.id.tb_main)
    TabLayout tbMain;
    @Bind(R.id.vp_main)
    ViewPager vpMain;
    @Bind(R.id.iv_home)
    ImageView ivHome;
    @Bind(R.id.iv_user)
    ImageView ivuser;
    @Bind(R.id.tv_login)
    TextView tvLogin;
    @Bind(R.id.iv_game)
    ImageView ivGame;
    @Bind(R.id.iv_download)
    ImageView ivDownload;
    @Bind(R.id.iv_search)
    ImageView ivSearch;
    private ArrayList<BaseFragment> fragments;
    private DrawerLayout drawerLayout;
    SearchFragment searchFragment = SearchFragment.newInstance();
    @Override
    protected void initListener() {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
            setHasOptionsMenu(true);
//        ActionBar supportActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
    }

    @Override
    protected void initData(String json) {
        Log.e("TAG", "initData");
        initFragement();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        ViewPagerAdapter adapter = new ViewPagerAdapter(fragmentManager, fragments);
        vpMain.setAdapter(adapter);
        tbMain.setupWithViewPager(vpMain);
        vpMain.setCurrentItem(1);
        setData();
        setPic();
    }

    private void setData() {
        UserDao mUserDao = MyApplication.getInstances().getDaoSession().getUserDao();
        SharedPreferences sp1 = getActivity().getSharedPreferences("user_info", MODE_PRIVATE);
        String name1 = sp1.getString("name", "Hero丿残月");
        SharedPreferences sp = getActivity().getSharedPreferences("loginState", MODE_PRIVATE);
        //判断当前是否是登录的状态
        if (sp.getBoolean("islogin", false)) {
            List<User> users = mUserDao.loadAll();
            for (User username : users) {
                String name = username.getName();
                if (name.equals(name1)) {
                    //设置数据
                    if (tvLogin != null) {
                        tvLogin.setText(name);
                    }
                }
            }
        }
    }

    private void setPic() {
        MainActivity activity = (MainActivity) getActivity();
        //得到是否更新过的布尔值
        Boolean update = activity.isUpdate();
        //判断是否保存用户的图片
        if (update) {
            //如果改变过，说明设置的头像
            File filesDir = null;
            FileInputStream fis = null;
            try {
                //判断是否挂载了sd卡
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    //外部存储路径
                    filesDir = getActivity().getExternalFilesDir("");
                } else {
                    filesDir = getActivity().getFilesDir(); //内部存储路径
                }
                //全路径
                File path = new File(filesDir, "123.png");
                if (path.exists()) {
                    //找到存贮图片的路径开始读取
                    fis = new FileInputStream(path);
                    Bitmap bitmap = BitmapFactory.decodeStream(fis);
                    //变成圆形
                    Bitmap circleBitmap = BitmapUtils.circleBitmap(bitmap);
                    if (ivuser!=null){

                        ivuser.setImageBitmap(circleBitmap);
                    }
                    //读取完以后布尔值改成false
//                    activity.saveImage(false);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void initFragement() {
        fragments = new ArrayList<>();
        fragments.add(new LiveFragment());
        fragments.add(new RecommendFragment());
        fragments.add(new AftersomeFragment());
        fragments.add(new PartitionFragment());
        fragments.add(new DiscoveryFragment());
    }

    @Override
    public int getLayoutid() {
        return R.layout.fragment_main;
    }

    @Override
    public String getChildUrl() {
        return null;
    }



    @OnClick({R.id.iv_home, R.id.iv_user, R.id.tv_login, R.id.iv_game, R.id.iv_download, R.id.iv_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_home:
                drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
               break;
            case R.id.iv_user:
                drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.tv_login:
                startActivity(new Intent(getActivity(),LoginActivity.class));
                getActivity().finish();
                break;
            case R.id.iv_game:
//                Toast.makeText(getActivity(), "游戏中心", Toast.LENGTH_SHORT).show();
//                showShare();
                break;
            case R.id.iv_download:
                startActivity(new Intent(getActivity(),DownLoadActivity.class));
                break;
            case R.id.iv_search:
                searchFragment.setOnSearchClickListener(new IOnSearchClickListener() {
                    @Override
                    public void OnSearchClick(String keyword) {
                        Toast.makeText(getActivity(), ""+keyword, Toast.LENGTH_SHORT).show();
                    }
                });
                searchFragment.show(getFragmentManager(),SearchFragment.TAG);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        setPic();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share:
                //调用系统的分享软件
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
                intent.putExtra(Intent.EXTRA_TEXT, "来自「哔哩哔哩」的分享:" + "http://bmall.bilibili.com/#!/");
                startActivity(Intent.createChooser(intent, "福利专区"));
                break;
            case R.id.action_copy:
                break;
            case R.id.action_settings:
                break;
        }
        return true;
    }
//    private void showShare() {
//        OnekeyShare oks = new OnekeyShare();
//        //关闭sso授权
//        oks.disableSSOWhenAuthorize();
//        // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
//        oks.setTitle("来自尚硅谷it教育");
//        // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
//        oks.setTitleUrl("http://atguigu.com/");
//        // text是分享文本，所有平台都需要这个字段
//        oks.setText("大王派我来巡山");
//        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
//        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
//        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
//        // url仅在微信（包括好友和朋友圈）中使用
//        oks.setUrl("http://atguigu.com/");
//        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
//        oks.setComment("尚硅谷it教育好");
//        // site是分享此内容的网站名称，仅在QQ空间使用
//        oks.setSite("尚硅谷it教育");
//        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
//        oks.setSiteUrl("http://atguigu.com/");
//
//// 启动分享GUI
//        oks.show(getActivity());
//    }
}
