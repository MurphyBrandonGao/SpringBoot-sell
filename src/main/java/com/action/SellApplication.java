package com.action;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
//@MapperScan(basePackages = "com.action.dataobject.mapper")
public class SellApplication {
	public static void main(String[] args) {
		SpringApplication.run(SellApplication.class, args);
	}
}
