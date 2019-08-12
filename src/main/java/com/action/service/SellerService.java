package com.action.service;

import com.action.dataobject.SellerInfo;

/**
 * @author Dell
 * @create 2019-08-12 21:22
 */
public interface SellerService {
    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
