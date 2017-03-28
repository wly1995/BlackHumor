package com.atguigu.blackhumor.fragment;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.activity.BuyActivity;
import com.atguigu.blackhumor.adapter.ShoppingCartAdapter;
import com.atguigu.blackhumor.bean.GoodsBean;
import com.atguigu.blackhumor.utils.CartStorage;
import com.atguigu.blackhumor.utils.pay.PayKeys;
import com.atguigu.blackhumor.utils.pay.PayResult;
import com.atguigu.blackhumor.utils.pay.SignUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by 万里洋 on 2017/3/28.
 */

public class ShopFragmennt extends BaseFragment {

    //商户PID
    public static final String PARTNER = PayKeys.PRIVATE;
    //商户收款账号
    public static final String SELLER = PayKeys.DEFAULT_SELLER;
    //商户私钥，pkcs8格式
    public static final String RSA_PRIVATE = PayKeys.PRIVATE;
    //支付宝公钥
    public static final String RSA_PUBLIC = PayKeys.PUBLIC;


    private static final int SDK_PAY_FLAG = 1;

    private static final int SDK_CHECK_FLAG = 2;


    @Bind(R.id.tv_shopcart_edit)
    TextView tvShopcartEdit;
    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;
    @Bind(R.id.checkbox_all)
    CheckBox checkboxAll;
    @Bind(R.id.tv_shopcart_total)
    TextView tvShopcartTotal;
    @Bind(R.id.btn_check_out)
    Button btnCheckOut;
    @Bind(R.id.ll_check_all)
    LinearLayout llCheckAll;
    @Bind(R.id.checkbox_delete_all)
    CheckBox checkboxDeleteAll;
    @Bind(R.id.btn_delete)
    Button btnDelete;
    @Bind(R.id.btn_collection)
    Button btnCollection;
    @Bind(R.id.ll_delete)
    LinearLayout llDelete;
    @Bind(R.id.iv_empty)
    ImageView ivEmpty;
    @Bind(R.id.tv_empty_cart_tobuy)
    TextView tvEmptyCartTobuy;
    @Bind(R.id.ll_empty_shopcart)
    LinearLayout llEmptyShopcart;
    private List<GoodsBean> datas;
    private ShoppingCartAdapter adapter;
    //编辑状态
    private static final int ACTION_EDIT = 1;
    //完成状态
    private static final int ACTION_COMPLETE = 2;
    @Override
    protected void initListener() {

    }

    @Override
    protected void initData(String json) {
        //设置默认的编辑状态
        tvShopcartEdit.setTag(ACTION_EDIT);
        tvShopcartEdit.setText("编辑");
        //显示去结算布局
        llCheckAll.setVisibility(View.VISIBLE);

        tvShopcartEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.得到状态
                int action = (int) v.getTag();
                //2.根据不同状态做不同的处理
                if (action == ACTION_EDIT) {
                    //切换完成状态
                    showDelete();
                } else {
                    //切换成编辑状态
                    hideDelete();
                }
            }
        });
        //展示数据
        showData();
    }

    private void showData() {
        //先从仓库中获取数据
        datas = CartStorage.getInstance(getActivity()).getAllData();
        //如果有数据就展示
        if(datas != null && datas.size() > 0){
            //有数据-隐藏
            llEmptyShopcart.setVisibility(View.GONE);
            //设置适配器
            adapter = new ShoppingCartAdapter(getActivity(),datas,checkboxAll,tvShopcartTotal,checkboxDeleteAll);
            recyclerview.setAdapter(adapter);
            recyclerview.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

            //adapter设置点击事件
            adapter.setOnItemClickListener(new ShoppingCartAdapter.OnItemClickListener() {
                @Override
                public void onItemClickListener(View view, int position) {//view  position 是从ShoppingCartAdapter传过来的，实现数据的传递
                    GoodsBean goodsBean = datas.get(position);
                    //状态取反，这时候不用再去存储 一遍，因为状态改变了地址值没变只是更新了状态
                    goodsBean.setChecked(!goodsBean.isChecked());
                    //适配器刷新视图
                    adapter.notifyItemChanged(position);
                    //在去计算价格
                    adapter.showTotalPrice();
                    //校验是否全选，这是在点击选择后的情况
                    adapter.checkAll();
                }
            });
            //默认有数据的时候也要判断是否全选
            adapter.checkAll();
        }else{
            //没有数据-显示没有数据的页面
            llEmptyShopcart.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){
            showData();
        }
    }

    @Override
    public int getLayoutid() {
        return R.layout.fragment_shop;
    }

    @Override
    public String getChildUrl() {
        return null;
    }

    private void showDelete() {
        //1.设置完成
        tvShopcartEdit.setTag(ACTION_COMPLETE);
        //2.显示删除控件
        llDelete.setVisibility(View.VISIBLE);
        //3.隐藏结算控件
        llCheckAll.setVisibility(View.GONE);
        //4.设置文本为-完成
        tvShopcartEdit.setText("完成");
        //5.把所有的数据设置非选择状态
        if(adapter != null){
            adapter.checkAll_none(false);
            adapter.checkAll();
            adapter.showTotalPrice();
        }

    }
    private void hideDelete() {
        //1.设置编辑
        tvShopcartEdit.setTag(ACTION_EDIT);
        //2.隐藏删除控件
        llDelete.setVisibility(View.GONE);
        //3.显示结算控件
        llCheckAll.setVisibility(View.VISIBLE);
        //4.设置文本为-编辑
        tvShopcartEdit.setText("编辑");
        //5.把所有的数据设置勾选择状态
        if(adapter != null){
            adapter.checkAll_none(true);
            //校验
            adapter.checkAll();
            adapter.showTotalPrice();
        }
    }
    @OnClick({R.id.tv_shopcart_edit, R.id.checkbox_all, R.id.btn_check_out, R.id.checkbox_delete_all, R.id.btn_delete, R.id.btn_collection, R.id.tv_empty_cart_tobuy})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_shopcart_edit:
                Toast.makeText(getActivity(), "编辑", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkbox_all:
                boolean checked = checkboxAll.isChecked();
                //全选、反选
                adapter.checkAll_none(checked);
                //显示总价格
                adapter.showTotalPrice();
                break;
            case R.id.btn_check_out:

                //进行支付
                pay();

                break;
            case R.id.checkbox_delete_all:
                checked = checkboxDeleteAll.isChecked();
                //全选、反选
                adapter.checkAll_none(checked);
                //显示总价格
                adapter.showTotalPrice();
                break;
            case R.id.btn_delete:
                //编辑界面选中的item会被删除
                adapter.deleteData();
                //要校验是否全选
                adapter.checkAll();
                //如果删除所有，就显示空购物车视图
                showEempty();
                break;
            case R.id.btn_collection:
                Toast.makeText(getActivity(), "收藏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_empty_cart_tobuy:
                BuyActivity buyActivity = (BuyActivity) getActivity();
                buyActivity.check();
                break;
        }
    }

    private void showEempty() {
        if(datas == null || datas.size() ==0){
            llEmptyShopcart.setVisibility(View.VISIBLE);
        }
    }

    private void pay() {
        //调支付宝
        // 订单
        String orderInfo = getOrderInfo("至高之拳", "瞎子大神专属皮肤", "99");
        // 对订单做RSA 签名
        String sign = sign(orderInfo);
        try {
            // 仅需对sign 做URL编码
            sign = URLEncoder.encode(sign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 完整的符合支付宝参数规范的订单信息
        final String payInfo = orderInfo + "&sign=\"" + sign + "\"&"
                + getSignType();

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                // 构造PayTask 对象
                PayTask alipay = new PayTask(getActivity());
                // 调用支付接口，获取支付结果
                String result = alipay.pay(payInfo);

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }


    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((String) msg.obj);

                    // 支付宝返回此次支付结果及加签，建议对支付宝签名信息拿签约时支付宝提供的公钥做验签
                    String resultInfo = payResult.getResult();

                    String resultStatus = payResult.getResultStatus();

                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        Toast.makeText(getActivity(), "支付成功",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        // 判断resultStatus 为非“9000”则代表可能支付失败
                        // “8000”代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            Toast.makeText(getActivity(), "支付结果确认中",
                                    Toast.LENGTH_SHORT).show();

                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            Toast.makeText(getActivity(), "支付失败",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                    break;
                }
                case SDK_CHECK_FLAG: {
                    Toast.makeText(getActivity(), "检查结果为：" + msg.obj,
                            Toast.LENGTH_SHORT).show();
                    break;
                }
                default:
                    break;
            }
        };
    };

    /**
     * create the order info. 创建订单信息
     */
    public String getOrderInfo(String subject, String body, String price) {
        // 签约合作者身份ID
        String orderInfo = "partner=" + "\"" + PARTNER + "\"";

        // 签约卖家支付宝账号
        orderInfo += "&seller_id=" + "\"" + SELLER + "\"";

        // 商户网站唯一订单号
        orderInfo += "&out_trade_no=" + "\"" + getOutTradeNo() + "\"";

        // 商品名称
        orderInfo += "&subject=" + "\"" + subject + "\"";

        // 商品详情
        orderInfo += "&body=" + "\"" + body + "\"";

        // 商品金额
        orderInfo += "&total_fee=" + "\"" + price + "\"";

        // 服务器异步通知页面路径
        orderInfo += "&notify_url=" + "\"" + "http://notify.msp.hk/notify.htm"
                + "\"";

        // 服务接口名称， 固定值
        orderInfo += "&service=\"mobile.securitypay.pay\"";

        // 支付类型， 固定值
        orderInfo += "&payment_type=\"1\"";

        // 参数编码， 固定值
        orderInfo += "&_input_charset=\"utf-8\"";

        // 设置未付款交易的超时时间
        // 默认30分钟，一旦超时，该笔交易就会自动被关闭。
        // 取值范围：1m～15d。
        // m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
        // 该参数数值不接受小数点，如1.5h，可转换为90m。
        orderInfo += "&it_b_pay=\"30m\"";

        // extern_token为经过快登授权获取到的alipay_open_id,带上此参数用户将使用授权的账户进行支付
        // orderInfo += "&extern_token=" + "\"" + extern_token + "\"";

        // 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
        orderInfo += "&return_url=\"m.alipay.com\"";

        // 调用银行卡支付，需配置此参数，参与签名， 固定值 （需要签约《无线银行卡快捷支付》才能使用）
        // orderInfo += "&paymethod=\"expressGateway\"";

        return orderInfo;
    }
    /**
     * get the out_trade_no for an order. 生成商户订单号，该值在商户端应保持唯一（可自定义格式规范）
     */
    public String getOutTradeNo() {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss",
                Locale.getDefault());
        Date date = new Date();
        String key = format.format(date);

        Random r = new Random();
        key = key + r.nextInt();
        key = key.substring(0, 15);
        return key;
    }

    public String sign(String content) {
        return SignUtils.sign(content, RSA_PRIVATE);
    }

    /**
     * get the sign type we use. 获取签名方式
     *
     */
    public String getSignType() {
        return "sign_type=\"RSA\"";
    }
}
