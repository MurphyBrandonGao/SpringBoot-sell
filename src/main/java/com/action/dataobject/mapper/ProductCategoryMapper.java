package com.action.dataobject.mapper;

import com.action.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author Dell
 * @create 2019-08-13 17:29
 */
public interface ProductCategoryMapper {
    @Insert("insert into product_category(category_name,category_type) VALUES (#{category_name, jdbcType=VARCHAR},#{category_type, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("INSERT INTO product_catetory(category_name,category_type) VALUES (#{category_name, jdbcType=VARCHAR},#{categoryType, jdbcType=INTEGER})")
    int insertByObject(ProductCategory productCategory);

    @Select("SELECT * FROM product_category WHERE category_type = #{categoryType}")
    @Results({@Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType"),
    })
    ProductCategory findByCategoryType(Integer categoryType);

    @Select("SELECT * FROM product_category WHERE category_name = #{categoryName}")
    @Results({@Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType"),
    })
    List<ProductCategory> findByCategoryName(String categoryName);

    @Update("UPDATE product_category set category_name = #{categoryName} WHERE category_type = #{categoryType}")
    int updateCategoryType(@Param("categoryName") String categoryName, @Param("categoryType") Integer categoryType);
}
