package com.action.constant;

/**
 * redis常量
 * @author Dell
 * @create 2019-08-13 1:07
 */
public interface RedisConstant {
    String TOKEN_PREFIX = "token_%s";
    Integer EXPIRE = 7200; // 2小时
}
