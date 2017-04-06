package com.atguigu.blackhumor.mvp.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
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
import static com.atguigu.blackhumor.R.id.username;

public class LoginActivity extends BaseActivity {


    @Bind(R.id.toolbar_iv_home)
    ImageView toolbarIvHome;
    @Bind(R.id.one)
    RelativeLayout one;
    @Bind(R.id.two)
    RelativeLayout two;
    @Bind(username)
    EditText et_username;
    @Bind(R.id.password)
    EditText et_password;
    @Bind(R.id.zhuce)
    TextView zhuce;
    @Bind(R.id.denglu)
    TextView denglu;
    //操作类
    private UserDao mUserDao;
    @Override
    protected void initListener() {
        et_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                one.setVisibility(View.GONE);
                two.setVisibility(View.VISIBLE);
            }
        });
        et_username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                one.setVisibility(View.VISIBLE);
                two.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void initData() {
        mUserDao = MyApplication.getInstances().getDaoSession().getUserDao();
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
                if (validate()){
                    List<User> users = mUserDao.loadAll();
                    String name = et_username.getText().toString().trim();
                    String wrod = et_password.getText().toString().trim();
                    for (int i = 0; i < users.size(); i++) {
                        String userName = users.get(i).getName();
                        if (name.equals(userName)) {
                            makeText(LoginActivity.this, "账号已存在", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    User mUser = new User(null, name, wrod);
                    mUserDao.insert(mUser);
                    Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.denglu:
                    if (validate()){
                        if (login()){
                            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(this, "用户名或者密码错误，请重新输入！", Toast.LENGTH_SHORT).show();
                        }
                    }
                break;
        }
    }
    // 验证方法是否为空
    private boolean validate(){
        String username = et_username.getText().toString();
        if(username.equals("")){
            Toast.makeText(this, "用户名不能为空！", Toast.LENGTH_SHORT).show();
            return false;
        }
        String pwd = et_password.getText().toString();
        if(pwd.equals("")){
            Toast.makeText(this, "用户密码不能为空！", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    // 登录方法
    private boolean login(){
        //1.获取输入框里面的东西
       String name1 = et_username.getText().toString().trim();
       String wrod1 = et_password.getText().toString().trim();
        //2.取出数据库中的数据集合，进行遍历
        List<User> user = mUserDao.loadAll();
        for (User list:user) {
           String userName =  list.getName();
           String userPw = list.getPassword();
            if (name1.equals(userName) && wrod1.equals(userPw)) {
                User user1 = new User(null, name1, wrod1);
                //把登陆成功的状态存入sp
                SharedPreferences sp = getSharedPreferences("loginState", MODE_PRIVATE);
                sp.edit().putBoolean("islogin", true).commit();
                //把当前登录的用户的名字存储到sp
                SharedPreferences sp1 = getSharedPreferences("user_info", MODE_PRIVATE);
                SharedPreferences.Editor edit = sp1.edit();
//                edit.putString("imageurl",userInfo.getData().getImageurl());
//                edit.putString("iscredit",userInfo.getData().getIscredit());
                edit.putString("name",user1.getName());
//                edit.putString("phone",userInfo.getData().getPhone());
                edit.commit();



                //跳转
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                intent.putExtra("name",user1);
                startActivity(intent);
                finish();

                return true;
            }
        }
        return false;
    }
}
