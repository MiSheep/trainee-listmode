package com.bosssoft.hr.train.utils;

import com.bosssoft.hr.train.entity.Goods;
import com.bosssoft.hr.train.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;

//通过实现CommandLineRunner接口，在spring boot项目启动后打印参数
@Component
public class CommandLineRunnerApplication implements CommandLineRunner {
    @Autowired
    GoodsService goodsService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("进入实现CommandLineRunner接口的方法");
        HashMap<Long,Goods> goodsHashMap = goodsService.getAllGoods();;
        System.out.println("商家A的初始商品总数量："+goodsHashMap.size());
    }
}
