package com.action.enums;

import lombok.Getter;

/**
 * @author Dell
 * @create 2019-08-08 15:48
 */
@Getter
public enum ResultEnum {

    PARAM_ERROR(1, "参数错误"),
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "商品库存不正确"),
    ORDER_NOT_EXIST(12, "订单不存在"),
    ORDERDETAIL_NOT_EXIST(13, "订单不存在"),
    ORDER_STATE_ERROR(14, "订单状态不正确"),
    ORDER_UPDATE_FATAL(15, "订单更新失败"),
    ORDER_DETAIL_EMPTY(16, "订单详情为空"),
    ORDER_PAY_STATUS_ERROR(17, "订单支付状态不正确"),
    CART_EMPTY(18, "购物车为空")
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
