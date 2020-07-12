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
 *  服务实现类
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

    @Override
    public void settle(long cartUid) {
        OrderInfo orderInfo = new OrderInfo();
        double totalPrice=0;
        HashMap<Long, Goods> cart = cartService.getCart();
        Iterator iterator = cart.keySet().iterator();
        Goods goodsTmp = null;
        OrderInfo orderInfoTmp = null;

        while(iterator.hasNext()){
            goodsTmp = (Goods) iterator.next();
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
