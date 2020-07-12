package com.bosssoft.hr.train.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author misheep
 * @since 2020-07-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("goods")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品uid
     */
    @TableId("goodsUID")
    private Long goodsUID;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品单价
     */
    private Float price;

    /**
     * 数量
     */
    private Integer number;


}
