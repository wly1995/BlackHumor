package com.atguigu.blackhumor.activity;

import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.player.DanmakuVideoPlayer;
import com.atguigu.blackhumor.player.SampleListener;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;

import butterknife.Bind;

public class DanmkuVideoActivity extends BaseActivity {

    @Bind(R.id.post_detail_nested_scroll)
    NestedScrollView postDetailNestedScroll;
    @Bind(R.id.danmaku_player)
    DanmakuVideoPlayer danmakuVideoPlayer;
    @Bind(R.id.activity_detail_player)
    RelativeLayout activityDetailPlayer;
    private OrientationUtils orientationUtils;

    private boolean isPlay;
    private boolean isPause;
    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        //使用自定义的全屏切换图片，!!!注意xml布局中也需要设置为一样的
        //必须在setUp之前设置
        danmakuVideoPlayer.setShrinkImageRes(R.drawable.custom_shrink);
        danmakuVideoPlayer.setEnlargeImageRes(R.drawable.custom_enlarge);

        String url = "http://baobab.wdjcdn.com/14564977406580.mp4";
        //String url = "https://res.exexm.com/cw_145225549855002";
        danmakuVideoPlayer.setUp(url, true, null, "测试视频");

        //增加封面
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.mipmap.xxx1);
        danmakuVideoPlayer.setThumbImageView(imageView);

        resolveNormalVideoUI();

        //外部辅助的旋转，帮助全屏
        orientationUtils = new OrientationUtils(this, danmakuVideoPlayer);
        //初始化不打开外部的旋转
        orientationUtils.setEnable(false);

        danmakuVideoPlayer.setIsTouchWiget(true);
        //关闭自动旋转
        danmakuVideoPlayer.setRotateViewAuto(false);
        danmakuVideoPlayer.setLockLand(false);
        danmakuVideoPlayer.setShowFullAnimation(false);
        danmakuVideoPlayer.setNeedLockFull(true);

        //detailPlayer.setOpenPreView(true);
        danmakuVideoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接横屏
                orientationUtils.resolveByClick();

                //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
                danmakuVideoPlayer.startWindowFullscreen(DanmkuVideoActivity.this, true, true);
            }
        });

        danmakuVideoPlayer.setStandardVideoAllCallBack(new SampleListener() {
            @Override
            public void onPrepared(String url, Object... objects) {
                super.onPrepared(url, objects);
                //开始播放了才能旋转和全屏
                orientationUtils.setEnable(true);
                isPlay = true;
            }

            @Override
            public void onAutoComplete(String url, Object... objects) {
                super.onAutoComplete(url, objects);
            }

            @Override
            public void onClickStartError(String url, Object... objects) {
                super.onClickStartError(url, objects);
            }

            @Override
            public void onQuitFullscreen(String url, Object... objects) {
                super.onQuitFullscreen(url, objects);
                if (orientationUtils != null) {
                    orientationUtils.backToProtVideo();
                }
            }
        });

        danmakuVideoPlayer.setLockClickListener(new LockClickListener() {
            @Override
            public void onClick(View view, boolean lock) {
                if (orientationUtils != null) {
                    //配合下方的onConfigurationChanged
                    orientationUtils.setEnable(!lock);
                }
            }
        });
    }

    @Override
    protected void initTitle() {

    }

    @Override
    public int getLayoutid() {
        return R.layout.activity_danmku_video;
    }
    private void resolveNormalVideoUI() {
        //增加title
        danmakuVideoPlayer.getTitleTextView().setVisibility(View.GONE);
        danmakuVideoPlayer.getTitleTextView().setText("测试视频");
        danmakuVideoPlayer.getBackButton().setVisibility(View.GONE);
    }
}
