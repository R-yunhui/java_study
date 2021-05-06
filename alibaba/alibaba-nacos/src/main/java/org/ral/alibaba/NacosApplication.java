/*
 * @projectName raladmin
 * @package org.ral.alibaba
 * @className org.ral.alibaba.NacosApplication
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package org.ral.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * NacosApplication
 * @Description
 * @author renyunhui
 * @date 2021/4/27 16:26
 * @version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosApplication.class, args);
    }
}
