package com.action.repository;

import com.action.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @author Dell
 * @create 2019-08-08 13:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    private final String OPENID = "110110";

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest() {
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("1234568");
        orderMaster.setBuyerName("师弟");
        orderMaster.setBuyerPhone("123456789123");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setOrderAmount(new BigDecimal(2.3));

        OrderMaster result=repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenId() {
        PageRequest pageRequest = new PageRequest(1, 3);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, pageRequest);
        Assert.assertNotEquals(0, result.getTotalElements());
        System.out.println(result.getTotalElements());
    }

}