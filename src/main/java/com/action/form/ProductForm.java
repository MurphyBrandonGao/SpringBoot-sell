package com.action.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Dell
 * @create 2019-08-12 18:42
 */
@Data
public class ProductForm {

    /**
     * 商品id
     */
    private String productId;

    /**
     * 名字
     **/
    private String productName;

    /**
     * 单价
     **/
    private BigDecimal productPrice;

    /**
     * 库存
     **/
    private Integer productStock;

    /**
     * 描述
     **/
    private String productDescription;

    /**
     * 小图
     **/
    private String productIcon;

    /**
     * 类目编号
     **/
    private Integer categoryType;
}
