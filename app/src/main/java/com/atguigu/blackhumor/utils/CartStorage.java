package com.atguigu.blackhumor.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;

import com.atguigu.blackhumor.service.entity.GoodsBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 万里洋 on 2017/2/27.
 * 购物车的一个储存类（单例）
 */

public class CartStorage {
    private static final String JSON_CART = "json_cart";
    private static CartStorage instance;
    private final Context mContext;
    //SparseArray替代HashMap,因为它更高效
    private SparseArray<GoodsBean> sparseArray;

    private CartStorage(Context context) {
        this.mContext = context;
        sparseArray = new SparseArray<GoodsBean>();

        listToSparseArray();
    }
    // 把list数据转化为SparseArray
    private void listToSparseArray() {
        //得到数据集合
        List<GoodsBean> beanList = getAllData();
        //循环起来，把数据转存到sparseArray
        for (int i = 0; i < beanList.size(); i++) {
            GoodsBean goodsBean = beanList.get(i);
            //通过产品di保存商品数据
            sparseArray.put(Integer.parseInt(goodsBean.getProduct_id()), goodsBean);
        }
    }

    /**
     * 获取全部数据
     * @return
     */
    public List<GoodsBean> getAllData() {
        return getLocalData();
    }

    //懒汉式  在我需要的时候才创建对象
    public static CartStorage getInstance(Context context){
        if (instance == null){//先判断有没有实例如果没有进行创建
            synchronized (CartStorage.class){//加锁是考虑到有可能同步创建这个时候就有可能创建多个对象
                if (instance == null){
                    instance =  new CartStorage(context);
                }
            }
        }
        return instance;
    }

    /**
     * 保存数据
     */
    private void commit() {
        //1.把sparseArray转成List
        List<GoodsBean> goodsBeanList = sparseArrayToList();
        //2.使用Gson把List转json的String类型数据
        String  savaJson = new Gson().toJson(goodsBeanList);
        //3.使用CacheUtils缓存数据
        CacheUtils.setString(mContext,JSON_CART,savaJson);


    }

    /**
     *把SparseArray数据转化为List
     * @return
     */
    private List<GoodsBean> sparseArrayToList() {
        //列表数据
        List<GoodsBean> goodsBeanList = new ArrayList<>();

        for (int i = 0; i < sparseArray.size(); i++) {
            GoodsBean goodsBean = sparseArray.valueAt(i);
            goodsBeanList.add(goodsBean);
        }

        return goodsBeanList;
    }
    /**
     * 增加数据
     * @param goodsBean
     */
    public void addData(GoodsBean goodsBean){
        //1.增加数据
        GoodsBean temp = sparseArray.get(Integer.valueOf(goodsBean.getProduct_id()));
        if(temp != null){
            //存在
            temp.setNumber(temp.getNumber());
        }else {
            temp = goodsBean;
            //至少设置1个
            temp.setNumber(temp.getNumber());
        }

        //添加  根据商品id存储商品的对象
        sparseArray.put(Integer.parseInt(temp.getProduct_id()),temp);


        //2.保持数据到本地
        commit();
    }

    public List<GoodsBean> getLocalData() {
        List<GoodsBean> goodsBeens = new ArrayList<>();
        //从本地获取数据
        String json = CacheUtils.getString(mContext, JSON_CART);
        //校验
        if (!TextUtils.isEmpty(json)){
            //把它转化成列表
            goodsBeens = new Gson().fromJson(json, new TypeToken<List<GoodsBean>>() {

            }.getType());
        }
        return goodsBeens;
    }
    /**
     * 删除数据
     * @param goodsBean
     */
    public void deleteData(GoodsBean goodsBean){
        //1.删除数据
        sparseArray.delete(Integer.parseInt(goodsBean.getProduct_id()));

        //2.保持到本地
        commit();
    }
    /**
     * 修改数据
     * @param goodsBean
     */
    public  void updateData(GoodsBean goodsBean){
        //1.更新数据
        sparseArray.put(Integer.parseInt(goodsBean.getProduct_id()),goodsBean);

        //2.保持到本地
        commit();
    }

    public GoodsBean findDate(String product_id) {
        GoodsBean goodsBean = sparseArray.get(Integer.parseInt(product_id));
        return goodsBean;
    }
}
