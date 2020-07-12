package com.bosssoft.hr.train.service.impl;

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
 *  服务实现类
 * </p>
 *
 * @author misheep
 * @since 2020-07-12
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public HashMap<Long,Goods> getAllGoods() {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        List<Goods> goodsList = goodsMapper.selectList(queryWrapper);
        HashMap<Long,Goods> goodsHashMap = new HashMap<>();
        goodsList.forEach(item->{
            goodsHashMap.put(item.getGoodsUID(),item);
        });
        return goodsHashMap;
    }
}
