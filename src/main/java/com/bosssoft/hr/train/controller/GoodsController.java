package com.bosssoft.hr.train.controller;


import com.alibaba.fastjson.JSONObject;
import com.bosssoft.hr.train.entity.Goods;
import com.bosssoft.hr.train.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * <p>
 * 商品
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
    public String getAllGoods() {
        HashMap<Long, Goods> goodsHashMap = goodsService.getAllGoods();
        if (goodsHashMap.size() == 0) {
            return "empty.please add Goods.";
        }
        return JSONObject.toJSONString(goodsHashMap.entrySet().toArray());
    }

    //获取全部货物
    @PostMapping("/getGoods")
    public String getGoods() {
        HashMap<Long, Goods> goodsHashMap = goodsService.getGoodsMap();
        if (goodsHashMap.size() == 0) {
            return "empty.please add Goods.";
        }
        return JSONObject.toJSONString(goodsHashMap.entrySet().toArray());
    }

    //增
    @PostMapping("/add")
    public String add(@RequestBody Goods goods) {
        if (!goodsService.add(goods)) {
            return "add failed.check your goodsUID and name";
        }
        return "admin add goods:" + goods.getName();
    }

    //删
    @PostMapping("/remove")
    public String remove(@RequestBody Goods goods) {
        if (!goodsService.remove(goods.getGoodsUID())) {
            return "remove failed.check your goodsUID";
        }
        return "admin remove goods:" + goods.getName();
    }

    //改
    @PostMapping("/edit")
    public String edit(@RequestBody Goods goods) {
        if (!goodsService.edit(goods)) {
            return "edit failed.check your goodsUID and name";
        }
        return "admin edit goods:" + goods.getName();
    }

    //查
    @PostMapping("/getOne")
    @ResponseBody
    public Goods getOne(String name) {
        Goods goods = goodsService.getOne(name);
        return goods;
    }

    //查
    @PostMapping("/getOneById")
    @ResponseBody
    public Goods getOneById(Long goodsUid) {
        Goods goods = goodsService.getOne(goodsUid);
        return goods;
    }

}
