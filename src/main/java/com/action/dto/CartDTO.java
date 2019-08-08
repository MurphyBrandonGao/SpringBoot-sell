package com.action.dto;

import lombok.Data;

/**
 * 购物车
 * @author Dell
 * @create 2019-08-08 16:44
 */
@Data
public class CartDTO {
    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
