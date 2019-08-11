package com.action.service;

import com.action.dataobject.OrderMaster;
import com.action.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Dell
 * @create 2019-08-08 14:50
 */
public interface OrderService {
    /**
     * 创建订单
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查询单个订单
     */
    OrderDTO findOne(String orderId);

    /**
     * 查询某个用户订单列表
     */
    Page<OrderDTO> findList(String buyerOpenId, Pageable pageable);

    /**
     * 取消订单
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完结订单
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单
     */
    OrderDTO paid(OrderDTO orderDTO);

    /**
     * 查询所有用户订单列表
     */
    Page<OrderDTO> findList(Pageable pageable);
}
