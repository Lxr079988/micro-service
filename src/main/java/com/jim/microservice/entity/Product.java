package com.jim.microservice.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.Order;

/**
 * 产品表(Product)表实体类
 *
 * @author jimliu
 * @since 2022-05-25 18:34:33
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("product")
@AllArgsConstructor
@NoArgsConstructor
public class Product extends Model<Product> implements Serializable {
    private static final long serialVersionUID = -17576240904489256L;

    @TableId(type = IdType.AUTO)
    private Integer id;
    //产品id
    private String productId;
    //国家
    private String country;
    //型号
    private String productModel;


    private Date createTime;

    private Date updateTime;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}

