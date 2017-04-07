package com.atguigu.blackhumor.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.service.entity.GoodsBean;
import com.atguigu.blackhumor.ui.fragment.UserFragment;
import com.atguigu.blackhumor.ui.view.AddSubView;
import com.atguigu.blackhumor.utils.CartStorage;
import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.OnClick;

public class GoodsInfoActivity extends BaseActivity {

    @Bind(R.id.ib_good_info_back)
    ImageButton ibGoodInfoBack;
    @Bind(R.id.ib_good_info_more)
    ImageButton ibGoodInfoMore;
    @Bind(R.id.iv_good_info_image)
    ImageView ivGoodInfoImage;
    @Bind(R.id.tv_good_info_name)
    TextView tvGoodInfoName;
    @Bind(R.id.tv_good_info_desc)
    TextView tvGoodInfoDesc;
    @Bind(R.id.tv_good_info_price)
    TextView tvGoodInfoPrice;
    @Bind(R.id.tv_good_info_store)
    TextView tvGoodInfoStore;
    @Bind(R.id.tv_good_info_style)
    TextView tvGoodInfoStyle;
    @Bind(R.id.wb_good_info_more)
    WebView wbGoodInfoMore;
    @Bind(R.id.progressbar)
    ProgressBar progressbar;
    @Bind(R.id.tv_good_info_callcenter)
    TextView tvGoodInfoCallcenter;
    @Bind(R.id.tv_good_info_collection)
    TextView tvGoodInfoCollection;
    @Bind(R.id.tv_good_info_cart)
    TextView tvGoodInfoCart;
    @Bind(R.id.btn_good_info_addcart)
    Button btnGoodInfoAddcart;
    @Bind(R.id.ll_goods_root)
    LinearLayout llGoodsRoot;
    @Bind(R.id.tv_more_share)
    TextView tvMoreShare;
    @Bind(R.id.tv_more_search)
    TextView tvMoreSearch;
    @Bind(R.id.tv_more_home)
    TextView tvMoreHome;
    @Bind(R.id.btn_more)
    Button btnMore;
    @Bind(R.id.ll_root)
    LinearLayout llRoot;
    private GoodsBean goodsBean;



    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        getData();
        setData();
    }

    @Override
    protected void initTitle() {

    }

    @Override
    public int getLayoutid() {
        return R.layout.activity_goods_info;
    }

    //取出intent
    private void getData() {
        goodsBean = (GoodsBean) getIntent().getSerializableExtra(UserFragment.GOODS_BEAN);
//        Toast.makeText(this, goodsBean.toString(), Toast.LENGTH_SHORT).show();
    }

    /**
     * 设置数据
     */
    private void setData() {
        //设置图片和名字和价格的数据
        String coverPrice = goodsBean.getCover_price();
        String figure = goodsBean.getFigure();
        String productId = goodsBean.getProduct_id();
        String name = goodsBean.getName();

        //设置图片
        Glide.with(this).load(figure).into(ivGoodInfoImage);
        tvGoodInfoName.setText(name);
        tvGoodInfoPrice.setText(coverPrice);

        //设置webView的数据
        setWebViewData(productId);
    }

    private void setWebViewData(String productId) {
        WebSettings webSettings = wbGoodInfoMore.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);
        //设置检索缓存的
        webSettings.setCacheMode(webSettings.LOAD_CACHE_ELSE_NETWORK);

        wbGoodInfoMore.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.loadUrl(request.getUrl().toString());
                }
                return true;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressbar.setVisibility(View.GONE);
            }
        });
        wbGoodInfoMore.loadUrl("http://bmall.bilibili.com/#!/");
    }

    @OnClick({R.id.ib_good_info_back,R.id.ib_good_info_more,R.id.tv_good_info_callcenter, R.id.tv_good_info_collection, R.id.tv_good_info_cart, R.id.btn_good_info_addcart, R.id.tv_more_share, R.id.tv_more_search, R.id.tv_more_home, R.id.btn_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_good_info_back:
                if (llRoot.isShown()){
                    llRoot.setVisibility(View.GONE);
                }else {
                    finish();
                }
                break;
            case R.id.ib_good_info_more:
                if (llRoot.isShown()){
                    llRoot.setVisibility(View.GONE);
                }else{
                    llRoot.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.tv_good_info_callcenter:
                Intent intent = new Intent(this, CallCenterActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_good_info_collection:
                Toast.makeText(this, "收藏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_good_info_cart:
//                Toast.makeText(this, "跳转到购物车", Toast.LENGTH_SHORT).show();
                intent = new Intent(this,BuyActivity.class);
                intent.putExtra("checkId",R.id.rb_cart);
                startActivity(intent);
                break;
            case R.id.btn_good_info_addcart:
                //弹出popwindow
                showPopwindow();
                break;
            case R.id.tv_more_share:
                Intent intent1 = new Intent(GoodsInfoActivity.this,GenrateActivity.class);
                intent1.putExtra(UserFragment.GOODS_BEAN,goodsBean);
                startActivity(intent1);

                break;
            case R.id.tv_more_search:
                Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_more_home:
                Toast.makeText(this, "更多", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_more:
                llRoot.setVisibility(View.GONE);
                break;
        }
    }
    //缓存的商品实体类
    private GoodsBean tempGoodsBean;
    private boolean isExist;
    private void showPopwindow() {
        //先从存储中根据id取出
        tempGoodsBean = CartStorage.getInstance(this).findDate(goodsBean.getProduct_id());
        //判断这个商品是否之前已经加过？
        if(tempGoodsBean == null){
            //之前购物车没有这件商品
            isExist = false;
            //则把当前的商品类对象给缓存的
            tempGoodsBean = goodsBean;
        }else {
            //之前购物车已经有了该物品
            isExist  =true;
        }

        // 1 利用layoutInflater获得View
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.popupwindow_add_product, null);

        // 2下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        //把加载的view放进popupwindow里面去
        final PopupWindow window = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        // 3 参数设置
        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xFFFFFFFF);
        window.setBackgroundDrawable(dw);

        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.mypopwindow_anim_style);


        // 4 控件处理
        ImageView iv_goodinfo_photo = (ImageView) view.findViewById(R.id.iv_goodinfo_photo);
        TextView tv_goodinfo_name = (TextView) view.findViewById(R.id.tv_goodinfo_name);
        TextView tv_goodinfo_price = (TextView) view.findViewById(R.id.tv_goodinfo_price);
        AddSubView nas_goodinfo_num = (AddSubView) view.findViewById(R.id.nas_goodinfo_num);
        Button bt_goodinfo_cancel = (Button) view.findViewById(R.id.bt_goodinfo_cancel);
        Button bt_goodinfo_confim = (Button) view.findViewById(R.id.bt_goodinfo_confim);

        // 加载图片
        Glide.with(GoodsInfoActivity.this).load(tempGoodsBean.getFigure()).into(iv_goodinfo_photo);

        // 名称
        tv_goodinfo_name.setText(tempGoodsBean.getName());
        // 显示价格
        tv_goodinfo_price.setText(tempGoodsBean.getCover_price());

        // 设置最大值和当前值
        nas_goodinfo_num.setMaxValue(10);
        nas_goodinfo_num.setValue(tempGoodsBean.getNumber());


        nas_goodinfo_num.setOnNumberChangerListener(new AddSubView.OnNumberChangerListener() {
            @Override
            public void onNumberChanger(int value) {
                //将数字和商品的数量统一起来
                tempGoodsBean.setNumber(value);
            }
        });

        bt_goodinfo_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
                //关闭popupwindow的时候将数量进行缓存
                tempGoodsBean.setNumber(tempGoodsBean.getNumber());
            }
        });

        bt_goodinfo_confim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
                //之前购物车没有，直接按确定键那么就会加一件去购物车
                if(isExist&& tempGoodsBean.getNumber()==1){
                    //数量加1
                    tempGoodsBean.setNumber(tempGoodsBean.getNumber()+1);
                }
                //添加购物车
                CartStorage.getInstance(GoodsInfoActivity.this).updateData(tempGoodsBean);
                Toast.makeText(GoodsInfoActivity.this, "添加购物车成功", Toast.LENGTH_SHORT).show();
            }
        });

        window.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                window.dismiss();
            }
        });

        // 5 在底部显示
        window.showAtLocation(GoodsInfoActivity.this.findViewById(R.id.ll_goods_root),
                Gravity.BOTTOM,0,0);
    }
}
