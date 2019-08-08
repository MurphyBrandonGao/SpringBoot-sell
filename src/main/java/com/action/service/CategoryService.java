package com.action.service;

import com.action.dataobject.ProductCategory;

import java.util.List;

/**
 * @author Dell
 * @create 2019-08-07 19:09
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory save(ProductCategory productCategory);
}
