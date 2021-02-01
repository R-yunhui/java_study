/*
 * @projectName raladmin
 * @package com.ral.admin.auth
 * @className com.ral.admin.auth.AuthApplication
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * AuthApplication
 * @Description 认证模块 启动类
 * @author renyunhui
 * @date 2021/2/1 15:50
 * @version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@MapperScan(value = "com.ral.admin.auth.dao")
@ComponentScan(basePackages = {"com.ral.admin"})
@EnableSwagger2
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
