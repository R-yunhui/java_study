package org.ral.alibaba.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @Author: RenYunHui
 * @Date: 2021-05-07 13:13
 * @Describe:
 * @Modify:
 */
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }
}
