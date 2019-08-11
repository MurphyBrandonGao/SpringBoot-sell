package com.action.service;

import com.action.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * @author Dell
 * @create 2019-08-11 10:37
 */
public interface PayService {
    PayResponse create(OrderDTO orderDTO);
    PayResponse notify(String notifyData);
    RefundResponse refound(OrderDTO orderDTO);
}
