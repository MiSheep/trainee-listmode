package com.bosssoft.hr.train.service;

import com.bosssoft.hr.train.entity.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author misheep
 * @since 2020-07-12
 */
public interface OrderInfoService extends IService<OrderInfo> {
    //提交购物车内商品
    public void settle(long cartUid);


}
