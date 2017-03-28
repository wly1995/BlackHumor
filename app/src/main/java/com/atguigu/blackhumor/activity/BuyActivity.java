package com.atguigu.blackhumor.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.fragment.BaseFragment;
import com.atguigu.blackhumor.fragment.HomeFragment;
import com.atguigu.blackhumor.fragment.ShopFragmennt;
import com.atguigu.blackhumor.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class BuyActivity extends BaseActivity {

    @Bind(R.id.ib_back)
    ImageButton ibBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.ib_more)
    ImageButton ibMore;
    @Bind(R.id.fl_buy)
    FrameLayout flBuy;
    @Bind(R.id.rg_buy)
    RadioGroup rgBuy;

    private List<BaseFragment> fragments;
    //当前fragment的位置
    private int poistion;
    //缓存的fragment
    private Fragment tempFragment;

    @Override
    protected void initListener() {
        rgBuy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        poistion = 0;
                        break;
                    case R.id.rb_cart:
                        poistion = 1;
                        break;
                    case R.id.rb_user:
                        poistion = 2;
                        break;
                }
                Fragment currentFragment = fragments.get(poistion);
                switchFragment(currentFragment);
            }
        });
        //默认选择
        rgBuy.check(R.id.rb_home);
    }
    //根据radiogroup的点击状态选取fragment
    private void switchFragment(Fragment currentFragment) {
        //只有缓存和当前不是一个fragment才进行切换
        if (tempFragment!=currentFragment){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //如果没有添加过就先添加
            if (!currentFragment.isAdded()){
                if (tempFragment!=null){
                    ft.hide(tempFragment);
                }
                //添加
                ft.add(R.id.fl_buy,currentFragment);
            }else{
                //如果添加了直接显示
                if (tempFragment!=null){
                    ft.hide(tempFragment);
                }
                ft.show(currentFragment);
            }
            //记得提交事务
            ft.commit();
            //在这进行缓存（把当前的fragment赋值给缓存）
            tempFragment = currentFragment;
        }
    }

    @Override
    protected void initData() {
        initFragment();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new ShopFragmennt());
        fragments.add(new UserFragment());
    }

    @Override
    protected void initTitle() {
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ibMore.setVisibility(View.INVISIBLE);
        tvTitle.setText("周边商城");
        tvTitle.setTextSize(15);
    }

    @Override
    public int getLayoutid() {
        return R.layout.activity_buy;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        //得到id
        int  checkId = intent.getIntExtra("checkId",R.id.rb_home);
        switch (checkId){
            case R.id.rb_home:
                //切换到主页面
                rgBuy.check(R.id.rb_home);
                break;
            case R.id.rb_cart:
                //切换到购物车
                rgBuy.check(R.id.rb_cart);
                break;
        }
    }
}
