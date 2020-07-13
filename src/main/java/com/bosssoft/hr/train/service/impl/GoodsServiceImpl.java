package com.bosssoft.hr.train.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bosssoft.hr.train.entity.Goods;
import com.bosssoft.hr.train.mapper.GoodsMapper;
import com.bosssoft.hr.train.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  商品
 * </p>
 *
 * @author misheep
 * @since 2020-07-12
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    //店家的商品清单，key=GoodsUid(商品主键),value=(商品类)
    private HashMap<Long,Goods> goodsHashMap;

    //从数据库获取店家全部商品
    @Override
    public HashMap<Long,Goods> getAllGoods() {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        //通过mybatis-plus的selectList方法，在queryWrapper不设条件时可获取该店家全部商品
        List<Goods> goodsList = goodsMapper.selectList(queryWrapper);
        goodsHashMap = new HashMap<>();
        //以key=GoodsUid(商品主键),value=(商品类)的方式存入HashMap
        goodsList.forEach(item->{
            goodsHashMap.put(item.getGoodsUID(),item);
        });
        return goodsHashMap;
    }

    //获取商品清单
    @Override
    public HashMap<Long, Goods> getGoodsMap() {
        return goodsHashMap;
    }
    //寻找商品信息
    @Override
    public boolean findGoods(Goods goods) {
        //判断商品实体类是否为空，或者是否存在数据库中
        if(goods==null || !goodsHashMap.containsKey(goods.getGoodsUID())) {
            return false;
        }
        Goods goods1 = goodsHashMap.get(goods.getGoodsUID());
        //判断该商品与店家商品清单中GoodsUid相等的商品的name和price是否相等
        if(goods.getName().equals(goods1.getName()) && goods.getPrice().equals(goods1.getPrice())){
            return true;
        }
        return false;
    }
}
