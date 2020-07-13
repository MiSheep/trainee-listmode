package com.bosssoft.hr.train.controller;


import com.alibaba.fastjson.JSONObject;
import com.bosssoft.hr.train.entity.Cart;
import com.bosssoft.hr.train.entity.Goods;
import com.bosssoft.hr.train.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  购物车
 * </p>
 *
 * @author misheep
 * @since 2020-07-12
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    //购物车中添加商品
    @PostMapping("/add")
    public String add(@RequestBody Goods goods){
        if(!cartService.add(goods)){
            return "add failed.check your goodsUID and name";
        }
        return "add goods:"+goods.getName();
    }

    //删
    @PostMapping("/remove")
    public String remove(@RequestBody Goods goods) {
        if(!cartService.remove(goods.getGoodsUID())){
            return "remove failed.check your goodsUID";
        }
        return "remove goods:"+goods.getName();
    }

    //改
    @PostMapping("/edit")
    public String edit(@RequestBody Goods goods) {
        if(!cartService.edit(goods.getGoodsUID(),goods.getNumber())){
            return "edit failed.check your goodsUID and number";
        }
        return "edit goods:"+goods.getName()+",set number:"+goods.getNumber();
    }

    //查
    @PostMapping("/list")
    public String list() {
        return cartService.getJSONString();
    }

    //提交（结算）
    @PostMapping("/settle")
    public String settle() {
        return cartService.settle();
    }

    //查找历史购物车信息
    @PostMapping("/cartHistory")
    @ResponseBody
    public Cart history(Long cartUid){
        return cartService.getHistory(cartUid);
    }


}
