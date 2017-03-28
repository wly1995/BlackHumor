package com.atguigu.blackhumor.bean;

import java.io.Serializable;

/**
 * Created by 万里洋 on 2017/2/25.
 */

public class GoodsBean implements Serializable {

    /**
     * cover_price : 138.00
     * figure : /supplier/1478873740576.jpg
     * name : 【尚硅谷】日常 萌系小天使卫衣--白色款
     * product_id : 10659
     */
    //商品的价格
    private String cover_price;
    //对应的图片
    private String figure;
    //商品的名称
    private String name;
    //商品的id
    private String product_id;
    /**
     * 是否选中
     */
    private boolean isChecked =true;

    public boolean isChecked() {
        return isChecked;
    }
    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public GoodsBean(String name, String cover_price, String figure, String product_id) {
        this.name = name;
        this.figure = figure;
        this.cover_price = cover_price;
        this.product_id = product_id;
    }

    public GoodsBean() {

    }

    public String getCover_price() {
        return cover_price;
    }

    public void setCover_price(String cover_price) {
        this.cover_price = cover_price;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    /**
     * 某个商品在购物车购买的数量
     * 默认值为1
     */
    private int number = 1;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return "GoodsBean{" +
                "cover_price='" + cover_price + '\'' +
                ", figure='" + figure + '\'' +
                ", name='" + name + '\'' +
                ", product_id='" + product_id + '\'' +
                ", number=" + number +
                '}';
    }
}
