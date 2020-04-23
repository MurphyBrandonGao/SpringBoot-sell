package com.action.service.impl;

import com.action.dto.OrderDTO;
import com.action.enums.ResultEnum;
import com.action.exception.SellException;
import com.action.service.OrderService;
import com.action.service.PayService;
import com.action.utils.JsonUtil;
import com.action.utils.MathUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dell
 * @create 2019-08-11 10:38
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    private static final String ORDER_NAME = "微信点餐订单";

    @Autowired
    private BestPayServiceImpl bestPayService;

    @Autowired
    private OrderService orderService;

    @Override
    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信支付】发起支付，request = {}", JsonUtil.toJson(payRequest));

        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("【微信支付】发起支付，response = {}", JsonUtil.toJson(payResponse));
        return payResponse;
    }

    @Override
    public PayResponse notify(String notifyData) {
        // 1.验证签名，是不是微信过来的请求参数
        // 2.支付的状态
        // 其中第1、2步SDK已经做了

        // 3.支付的金额
        // 4.支付的人（下单人 == 支付人）
        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("【微信支付】异步通知, payResponse={}", JsonUtil.toJson(payResponse));

        // 查询订单
        OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());

        // 判断订单是否存在
        if (orderDTO == null) {
            log.error("【微信支付】异步通知，订单不存在，orderId={}", payResponse.getOrderId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        // 判断微信通知金额与系统金额是否一致
        if (!MathUtil.equals(payResponse.getOrderAmount(), orderDTO.getOrderAmount().doubleValue())) {
            log.error("【微信支付】异步通知，订单金额不一致，微信通知金额={}，系统金额={}",
                    payResponse.getOrderAmount(), orderDTO.getOrderAmount());
            throw new SellException(ResultEnum.WXPAY_NOTIFY_MONEY_VERTIFY_ERROR);
        }

        // 修改订单的支付状态
        orderService.paid(orderDTO);

        return payResponse;
    }

    /**
     * 退款
     * @param orderDTO 订单传输对象
     */
    @Override
    public RefundResponse refound(OrderDTO orderDTO) {
        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setOrderId(orderDTO.getOrderId());
        refundRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信退款】request={}", JsonUtil.toJson(refundRequest));

        RefundResponse refundResponse = bestPayService.refund(refundRequest);
        log.info("【微信退款】response={}", JsonUtil.toJson(refundResponse));

        return refundResponse;
    }
}
