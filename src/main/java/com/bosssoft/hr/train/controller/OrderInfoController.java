package com.bosssoft.hr.train.controller;


import com.bosssoft.hr.train.entity.Cart;
import com.bosssoft.hr.train.entity.OrderInfo;
import com.bosssoft.hr.train.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  商品订单（购物车内商品）
 * </p>
 *
 * @author misheep
 * @since 2020-07-12
 */
@RestController
@RequestMapping("/order")
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;

    //查找历史购物车信息
    @PostMapping("/orderHistory")
    @ResponseBody
    public List<OrderInfo> history(Long cartUid){
        return orderInfoService.getHistory(cartUid);
    }

}
