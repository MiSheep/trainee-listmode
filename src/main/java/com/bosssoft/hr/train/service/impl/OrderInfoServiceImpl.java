package com.bosssoft.hr.train.service.impl;

import com.bosssoft.hr.train.entity.Goods;
import com.bosssoft.hr.train.entity.OrderInfo;
import com.bosssoft.hr.train.mapper.OrderInfoMapper;
import com.bosssoft.hr.train.service.CartService;
import com.bosssoft.hr.train.service.OrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;

/**
 * <p>
 *  商品订单（购物车内商品）
 * </p>
 *
 * @author misheep
 * @since 2020-07-12
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    //提交（结算）购物车内商品订单
    @Override
    public void settle(long cartUid) {
        //获取购物车map，key=GoodsUid(商品主键),value=(商品类)
        HashMap<Long, Goods> cart = cartService.getCart();
        //购物车内商品主键的迭代器
        Iterator iterator = cart.keySet().iterator();
        //临时商品对象，指向当前遍历的车内商品
        Goods goodsTmp = null;
        //临时商品订单对象
        OrderInfo orderInfoTmp = null;
        //遍历车内商品，写入数据库
        while(iterator.hasNext()){
            goodsTmp = (Goods) cart.get(iterator.next());
            orderInfoTmp = new OrderInfo();
            orderInfoTmp.setCartUID(cartUid);
            orderInfoTmp.setGoodsUID(goodsTmp.getGoodsUID());
            orderInfoTmp.setName(goodsTmp.getName());
            orderInfoTmp.setNumber(goodsTmp.getNumber());
            orderInfoTmp.setPrice(goodsTmp.getPrice());
            orderInfoMapper.insert(orderInfoTmp);
        }
    }
}
