package com.atguigu.blackhumor.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.anye.greendao.gen.UserDao;
import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.application.MyApplication;
import com.atguigu.blackhumor.bean.User;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

import static android.widget.Toast.makeText;

public class LoginActivity extends BaseActivity {


    @Bind(R.id.toolbar_iv_home)
    ImageView toolbarIvHome;
    @Bind(R.id.one)
    RelativeLayout one;
    @Bind(R.id.two)
    RelativeLayout two;
    @Bind(R.id.username)
    EditText username;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.zhuce)
    TextView zhuce;
    @Bind(R.id.denglu)
    TextView denglu;
    //获取的用户名
    private String name;
    //获取的密码
    private String wrod;
    //操作类
    private UserDao mUserDao;
    //从数据库中得到每个用户名
    private String userName;
    //从数据库每个用户的密码
    private String userPw;

    @Override
    protected void initListener() {
        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                one.setVisibility(View.GONE);
                two.setVisibility(View.VISIBLE);
            }
        });
        username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                one.setVisibility(View.VISIBLE);
                two.setVisibility(View.GONE);
            }
        });
//        //check();
//        username.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                if (TextUtils.isEmpty(username.getText().toString().trim())){
//                    denglu.setEnabled(false);
//                }else{
//                    denglu.setEnabled(true);
//                }
//            }
//        });
//        password.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                if (TextUtils.isEmpty(password.getText().toString().trim())){
//                    denglu.setEnabled(false);
//                }else {
//                    denglu.setEnabled(true);
//                }
//            }
//        });
    }

    @Override
    protected void initData() {
        mUserDao = MyApplication.getInstances().getDaoSession().getUserDao();
        name = username.getText().toString().trim();
        wrod = password.getText().toString().trim();
    }

    @Override
    protected void initTitle() {

    }

    @Override
    public int getLayoutid() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.toolbar_iv_home, R.id.zhuce, R.id.denglu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_iv_home:
                finish();
                break;
           case R.id.zhuce:
               List<User> users = mUserDao.loadAll();
                for (int i = 0; i <= users.size(); i++) {
                    if(users.size() > 0) {
                        userName = users.get(i).getName();
                        if (TextUtils.isEmpty(userName) || !name.equals(userName)) {
                            User mUser = new User(null, name, wrod);
                            mUserDao.insert(mUser);
                            makeText(LoginActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        } else if (name.equals(userName)) {
                            makeText(LoginActivity.this, "账号已存在", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                       User mUser = new User(null, name, wrod);
                        mUserDao.insert(mUser);
                        makeText(LoginActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.denglu:
                List<User> user = mUserDao.loadAll();
                for (int i = 0; i < user.size(); i++) {
                    userName = user.get(i).getName();
                    userPw = user.get(i).getPassword();

                    if(name.equals(userName) && wrod.equals(userPw)) {
                        Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                        //把登陆成功的状态存入sp
                        boolean isLogin = true;
                        SharedPreferences sp =  getSharedPreferences("loginState", MODE_PRIVATE);
                        sp.edit().putBoolean("islogin",isLogin).commit();
                        //跳转
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        intent.putExtra("name",userName);
                        startActivity(intent);
                        finish();
                    }
                }
                break;
        }
    }
}
