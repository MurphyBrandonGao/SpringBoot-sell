package com.action.form;

import lombok.Data;

/**
 * @author Dell
 * @create 2019-08-12 19:40
 */
@Data
public class CategoryForm {
    private Integer categoryId;
    /**
     * 类目名字
     */
    private String categoryName;
    /**
     * 类目编号
     */
    private Integer categoryType;
}
