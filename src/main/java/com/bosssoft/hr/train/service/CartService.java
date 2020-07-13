package com.bosssoft.hr.train.service;

import com.bosssoft.hr.train.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bosssoft.hr.train.entity.Goods;

import java.util.HashMap;

/**
 * <p>
 *  购物车
 * </p>
 *
 * @author misheep
 * @since 2020-07-12
 */
public interface CartService extends IService<Cart> {
    //购物车中新增商品
    public boolean add(Goods goods);
    //删
    public boolean remove(long goodsUid);
    //改
    public boolean edit(long goodsUid, int number);
    //查
    public String getJSONString();
    //提交购物车
    public String settle();
    //模拟获得用户id
    public long getOwnerId();
    //从session中获得当前购物车
    public HashMap<Long, Goods> getCart();
    //查找历史购物车，by购物车uid
    public Cart getHistory(Long cartUid);

}
