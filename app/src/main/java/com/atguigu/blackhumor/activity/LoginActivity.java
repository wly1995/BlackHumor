package com.atguigu.blackhumor.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.blackhumor.R;

import butterknife.Bind;
import butterknife.OnClick;

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
    private String name;
    private String wrod;

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

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(wrod)){
            denglu.setEnabled(true);
        }else {
            denglu.setEnabled(false);
        }

    }

    @Override
    protected void initData() {
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
                break;
            case R.id.denglu:
                startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }
}
