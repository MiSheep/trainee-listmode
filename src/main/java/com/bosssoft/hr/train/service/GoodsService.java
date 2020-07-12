package com.bosssoft.hr.train.service;

import com.bosssoft.hr.train.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author misheep
 * @since 2020-07-12
 */
public interface GoodsService extends IService<Goods> {
    //获取店家全部货物
    public HashMap<Long,Goods> getAllGoods();

}
