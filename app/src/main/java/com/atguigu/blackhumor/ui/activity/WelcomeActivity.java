package com.atguigu.blackhumor.ui.activity;

import android.content.Intent;
import android.os.Handler;

import com.atguigu.blackhumor.R;

public class WelcomeActivity extends BaseActivity {
    private Handler handler = new Handler();
    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startMainActivity();
            }
        },3000);
    }

    @Override
    protected void initTitle() {

    }

    @Override
    public int getLayoutid() {
        return R.layout.activity_welcome;
    }

    private void startMainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
