package com.action.repository;

import com.action.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dell
 * @create 2019-08-07 17:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
        Assert.assertNotEquals(productCategory, null);
    }

    @Test
    @Transactional
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("男生最爱", 8);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
        Assert.assertNotEquals(null, result);
    }

    @Test
    public void updateTest() {
        ProductCategory productCategory = repository.findOne(2);
        productCategory.setCategoryType(10);
        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeIntest() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }
}