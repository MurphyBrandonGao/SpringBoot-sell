package com.action.dataobject;

import com.action.enums.OrderStatusEnum;
import com.action.enums.PayStatusEnum;
import com.action.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Dell
 * @create 2019-08-08 13:24
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    /**订单**/
    @Id
    private String orderId;

    /**买家名字 **/
    private String buyerName;

    /**卖家手机号**/
    private String buyerPhone;

    /**卖家地址**/
    private String buyerAddress;

    /**买家微信Openid*/
    private String buyerOpenid;

    /**订单金额*/
    private BigDecimal orderAmount;

    /**订单状态，默认为新下单*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /**支付状态，默认为0未支付*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /**创建时间*/
    private Date createTime;

    /**更新时间*/
    private Date updateTime;
}
