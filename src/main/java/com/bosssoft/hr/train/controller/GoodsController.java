package com.bosssoft.hr.train.controller;


import com.alibaba.fastjson.JSONObject;
import com.bosssoft.hr.train.entity.Goods;
import com.bosssoft.hr.train.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 *  商品
 * </p>
 *
 * @author misheep
 * @since 2020-07-12
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    //获取全部货物（通过数据库）
    @PostMapping("/getAllGoods")
    public String getAllGoods(){
        HashMap<Long, Goods> goodsHashMap = goodsService.getAllGoods();
        return JSONObject.toJSONString(goodsHashMap.entrySet().toArray());
    }
    //获取全部货物
    @PostMapping("/getGoods")
    public String getGoods(){
        HashMap<Long, Goods> goodsHashMap = goodsService.getGoodsMap();
        return JSONObject.toJSONString(goodsHashMap.entrySet().toArray());
    }

}
