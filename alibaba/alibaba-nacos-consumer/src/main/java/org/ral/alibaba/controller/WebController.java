/*
 * @projectName raladmin
 * @package org.ral.alibaba.controller
 * @className org.ral.alibaba.controller.WebController
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package org.ral.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * WebController
 * @Description
 * @author renyunhui
 * @date 2021/4/27 17:01
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/v1/web")
public class WebController {

    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/sayPort")
    public String sayPort() {
        // 使用 LoadBalanceClient 和 RestTemplate 结合的方式来访问
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-8081");
        String url = String.format("http://%s:%s/api/v1/web/sayPort", serviceInstance.getHost(), serviceInstance.getPort());
        System.out.println("request url:" + url);
        return restTemplate.getForObject(url, String.class);
    }
}
