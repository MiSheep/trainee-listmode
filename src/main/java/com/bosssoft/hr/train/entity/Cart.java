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
@TableName("cart")
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * cart主键uid
     */
    @TableId(value = "cartUID", type = IdType.AUTO)
    private Long cartUID;

    /**
     * 用户uid，购买者
     */
    @TableField("userUID")
    private Long userUID;

    /**
     * 总价格
     */
    @TableField("totalPrice")
    private Float totalPrice;


}
