package com.bosssoft.hr.train.service;

import com.bosssoft.hr.train.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;

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
public interface GoodsService extends IService<Goods> {
    //从数据库获取店家全部商品
    public HashMap<Long,Goods> getAllGoods();
    //获取商品清单
    public HashMap<Long,Goods> getGoodsMap();
    //寻找商品信息
    public boolean findGoods(Goods goods);
    //增加商品（店主维护商品列表）
    public boolean add(Goods goods);
    //删
    public boolean remove(long goodsUid);
    //改
    public boolean edit(Goods goods);
    //查，通过name
    public Goods getOne(String name);
    //查，通过id
    public Goods getOne(long goodsUid);

}
