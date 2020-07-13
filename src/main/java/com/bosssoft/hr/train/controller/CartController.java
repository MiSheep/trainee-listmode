package com.bosssoft.hr.train.controller;


import com.bosssoft.hr.train.entity.Goods;
import com.bosssoft.hr.train.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/add")
    public String add(@RequestBody Goods goods){
        cartService.add(goods);
        return "add goods:"+goods.getName();
    }
    @PostMapping("/remove")
    public String remove(@RequestBody Goods goods) {
        cartService.remove(goods.getGoodsUID());
        return null;
    }

    @PostMapping("/edit")
    public String edit(@RequestBody Goods goods) {
        cartService.edit(goods.getGoodsUID(),goods.getNumber());
        return null;
    }

    @PostMapping("/list")
    public String list() {
        return cartService.getJSONString();
    }

    @PostMapping("/settle")
    public String settle() {
        return cartService.settle();
    }

}
