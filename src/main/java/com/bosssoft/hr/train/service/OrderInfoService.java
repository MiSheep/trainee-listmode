package com.bosssoft.hr.train.service;

import com.bosssoft.hr.train.entity.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  商品订单（购物车内商品）
 * </p>
 *
 * @author misheep
 * @since 2020-07-12
 */
public interface OrderInfoService extends IService<OrderInfo> {
    //提交购物车内商品
    public void settle(long cartUid);
    //获取历史购物车内商品信息
    //注：原计划HashMap存储，key=cartUid(购物车主键),value=(订单类List，即该购物车下订单信息)
    public List<OrderInfo> getHistory(long cartUid);

}
