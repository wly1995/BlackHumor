package com.atguigu.blackhumor.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.activity.GoodsInfoActivity;
import com.atguigu.blackhumor.bean.GoodsBean;
import com.atguigu.blackhumor.fragment.UserFragment;
import com.atguigu.blackhumor.utils.CartStorage;
import com.atguigu.blackhumor.view.AddSubView;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Bind;
/**
 * Created by 万里洋 on 2017/2/28.
 */

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.MyViewHolder> {
    private final Context mContext;
    private final List<GoodsBean> datas;
    private final CheckBox checkboxAll;
    private final TextView tvShopcartTotal;
    private final CheckBox checkboxDeleteAll;


    public ShoppingCartAdapter(Context mContext, List<GoodsBean> datas,
                               CheckBox checkboxAll, TextView tvShopcartTotal, CheckBox checkboxDeleteAll) {
        this.mContext = mContext;
        this.datas = datas;
        this.checkboxAll = checkboxAll;
        this.tvShopcartTotal = tvShopcartTotal;
        this.checkboxDeleteAll = checkboxDeleteAll;
        showTotalPrice();
    }

    public  void showTotalPrice() {
        //显示总价格
        tvShopcartTotal.setText("合计:"+getTotalPrice());
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        if(datas != null && datas.size() >0){
            for (int i=0;i<datas.size();i++){
                GoodsBean goodsBean = datas.get(i);
                if(goodsBean.isChecked()){//根据是否选中的状态来计算总价
                    totalPrice += Double.parseDouble(goodsBean.getCover_price()) * goodsBean.getNumber();
                }
            }
        }
        return totalPrice;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(View.inflate(mContext, R.layout.item_shop_cart, null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //1.更加位置得到数据
        final GoodsBean goodsBean = datas.get(position);
        //2.绑定数据
        holder.cbGov.setChecked(goodsBean.isChecked());
        //图片
        Glide.with(mContext).load(goodsBean.getFigure()).into(holder.ivGov);
        holder.ivGov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, GoodsInfoActivity.class);
                intent.putExtra(UserFragment.GOODS_BEAN,goodsBean);
                mContext.startActivity(intent);
            }
        });
        holder.tvDescGov.setText(goodsBean.getName());
        //设置价格
        holder.tvPriceGov.setText(goodsBean.getCover_price());
        holder.addSubView.setValue(goodsBean.getNumber());

        holder.addSubView.setMinValue(1);
        //设置库存
        holder.addSubView.setMaxValue(50);
        //点击加减按钮会回调这个方法，把那边的value会传过来
        holder.addSubView.setOnNumberChangerListener(new AddSubView.OnNumberChangerListener() {
            @Override
            public void onNumberChanger(int value) {
                //1.回调数量，这个数量是从AddSubView中获取到的，运用了接口的回调
                goodsBean.setNumber(value);
                //本地进行更新
                CartStorage.getInstance(mContext).updateData(goodsBean);
                //然后更新总价格
                showTotalPrice();

            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    /**
     * 校验是否全选
     */
    public void checkAll() {
        if (datas!=null && datas.size()>0){
            //有数据
            int number = 0;
            for (int i =0;i<datas.size();i++){
                GoodsBean goodsBean = datas.get(i);
                if (!goodsBean.isChecked()){
                    checkboxAll.setChecked(false);
                    checkboxDeleteAll.setChecked(false);
                }else {
                    //勾选
                    number++;
                }
            }
            if(datas.size() == number){
                checkboxAll.setChecked(true);
                checkboxDeleteAll.setChecked(true);
            }
        } else {//默认为不勾选
            checkboxAll.setChecked(false);
            checkboxDeleteAll.setChecked(false);
        }
    }

    public void checkAll_none(boolean checked) {
        if (datas != null && datas.size() > 0) {
            for (int i = 0; i < datas.size(); i++) {
                //每一个item的状态和全选按钮状态一样
                datas.get(i).setChecked(checked);
                checkboxAll.setChecked(checked);
                //一定要记得刷新视图
                notifyItemChanged(i);
            }
        } else {
            checkboxAll.setChecked(false);
        }
    }

    /**
     * 删除数据
     */
    public void deleteData() {
        if(datas != null && datas.size() >0){
            for (int i=0;i<datas.size();i++){
                GoodsBean goodsBean = datas.get(i);
                if(goodsBean.isChecked()){
                    //1.内存中删除
                    datas.remove(goodsBean);
                    //2.本地也好保持
                    CartStorage.getInstance(mContext).deleteData(goodsBean);
                    //刷新数据
                    notifyItemRemoved(i);
                    i--;
                }
            }
        }
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.cb_gov)
        CheckBox cbGov;
        @Bind(R.id.iv_gov)
        ImageView ivGov;
        @Bind(R.id.tv_desc_gov)
        TextView tvDescGov;
        @Bind(R.id.tv_price_gov)
        TextView tvPriceGov;
        @Bind(R.id.addSubView)
        AddSubView addSubView;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClickListener!=null) {
                        itemClickListener.onItemClickListener(v,getLayoutPosition());
                    }
                }
            });
        }
    }

    //回调点击事件的监听
    private OnItemClickListener itemClickListener;

    /**
     * 点击item的监听
     */
    public interface OnItemClickListener {
        void onItemClickListener(View view, int position);
    }

    /**
     * 设置item的监听
     * @param l
     */
    public void setOnItemClickListener(OnItemClickListener l) {
        this.itemClickListener = l;
    }

}

