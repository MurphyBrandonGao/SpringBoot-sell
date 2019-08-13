package com.action.service;

import com.action.dto.OrderDTO;

/**
 * 推送消息
 * @author Dell
 * @create 2019-08-13 11:23
 */
public interface PushMessageService {
    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
