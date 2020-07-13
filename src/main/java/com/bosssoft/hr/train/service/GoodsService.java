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

}
