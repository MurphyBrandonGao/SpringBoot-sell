package com.action.service;

import com.action.dataobject.ProductInfo;
import com.action.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Dell
 * @create 2019-08-07 19:09
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品列表
     * @return 所有商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询某一页商品
     * @param pageable 分页
     * @return 某一页商品
     */
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    // 加库存
    void increaseStock(List<CartDTO> cartDTOList);

    // 减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    // 上架
    ProductInfo onSale(String productId);

    // 下架
    ProductInfo offSale(String productId);
}
