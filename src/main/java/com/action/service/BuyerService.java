package com.action.service;

import com.action.dto.OrderDTO;

/**
 * 买家
 * @author Dell
 * @create 2019-08-10 22:42
 */
public interface BuyerService {
    // 查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    // 取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
