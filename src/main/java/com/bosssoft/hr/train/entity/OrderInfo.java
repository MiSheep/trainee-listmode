package com.bosssoft.hr.train.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("order_info")
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * order主键
     */
    @TableId(value = "orderInfoUID", type = IdType.AUTO)
    private Long orderInfoUID;

    /**
     * order所属cart的uid
     */
    @TableField("cartUID")
    private Long cartUID;

    /**
     * 商品uid
     */
    @TableField("goodsUID")
    private Long goodsUID;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品购买数量
     */
    private Integer number;

    /**
     * 商品单价
     */
    private Float price;


}
