package com.action.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品（包含类目）
 * @author Dell
 * @create 2019-08-07 21:52
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = -7591746201841282447L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
