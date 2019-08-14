package com.action.dataobject;

import com.action.enums.ProductStatusEnum;
import com.action.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Dell
 * @create 2019-08-07 19:36
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    private static final long serialVersionUID = 3444372857205574860L;

    @Id
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

    /**状态，0正常，1下架**/
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /**
     * 类目编号
     **/
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }

}