package com.action.repository;

import com.action.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Dell
 * @create 2019-08-08 13:40
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
    /**
     * 按照买家的openId来查
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);

}
