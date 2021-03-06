package com.atguigu.blackhumor.ui.activity;

import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.service.entity.HomeBean;
import com.atguigu.blackhumor.service.player.DanmakuVideoPlayer;
import com.atguigu.blackhumor.service.player.SampleListener;
import com.atguigu.blackhumor.ui.view.CircleImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;

import butterknife.Bind;
import butterknife.OnClick;

public class DanmkuVideoActivity extends BaseActivity {


    @Bind(R.id.danmaku_player)
    DanmakuVideoPlayer danmakuVideoPlayer;
    @Bind(R.id.ib_back)
    ImageButton ibBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.ib_more)
    ImageButton ibMore;
    @Bind(R.id.bili_anim)
    ImageView biliAnim;
    @Bind(R.id.video_start_info)
    TextView videoStartInfo;
    @Bind(R.id.right_play)
    ImageView rightPlay;
    @Bind(R.id.bottom_play)
    ImageView bottomPlay;
    @Bind(R.id.bottom_love)
    ImageView bottomLove;
    @Bind(R.id.bottom_fullscreen)
    ImageView bottomFullscreen;
    @Bind(R.id.bottom_layout)
    RelativeLayout bottomLayout;
    @Bind(R.id.love_layout)
    RelativeLayout loveLayout;
    @Bind(R.id.user_pic)
    CircleImageView userPic;
    @Bind(R.id.user_name)
    TextView userName;
    @Bind(R.id.live_num)
    TextView liveNum;

    private OrientationUtils orientationUtils;

    private boolean isPlay;
    private boolean isPause;
    private HomeBean.DataBean.PartitionsBean.LivesBean livesBean;

    @Override
    protected void initListener() {
        tvTitle.setText(livesBean.getTitle());
        Glide.with(this).load(livesBean.getOwner().getFace()).asBitmap().centerCrop().into(new BitmapImageViewTarget(userPic) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(DanmkuVideoActivity.this.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                userPic.setImageDrawable(circularBitmapDrawable);
            }
        });
        liveNum.setText(livesBean.getOnline()+"");
        userName.setText(livesBean.getOwner().getName());
    }

    @Override
    protected void initData() {

//        String url = getIntent().getStringExtra("url");
        livesBean = (HomeBean.DataBean.PartitionsBean.LivesBean) getIntent().getSerializableExtra("url");


        //使用自定义的全屏切换图片，!!!注意xml布局中也需要设置为一样的
        //必须在setUp之前设置
        danmakuVideoPlayer.setShrinkImageRes(R.drawable.ic_live_palyer_zoom_in);
        danmakuVideoPlayer.setEnlargeImageRes(R.drawable.ic_live_palyer_zoom_in);

//        String url = "http://baobab.wdjcdn.com/14564977406580.mp4";
        String url = "https://res.exexm.com/cw_145225549855002";
        danmakuVideoPlayer.setUp(livesBean.getPlayurl(), true, null, livesBean.getTitle());

        //增加封面
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        Glide.with(this).load(livesBean.getCover()).into(imageView);
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
        danmakuVideoPlayer.getBackButton().setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        danmakuVideoPlayer.onVideoPause();
        super.onBackPressed();
    }
    @OnClick({R.id.ib_back, R.id.user_pic})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_back:
                finish();
                danmakuVideoPlayer.onVideoPause();
                break;
            case R.id.user_pic:
                Toast.makeText(this, "点击头像", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
