package org.ral.alibaba.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: RenYunHui
 * @Date: 2021-05-07 13:20
 * @Describe:
 * @Modify:
 */
@RestController
public class WebController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/sayHello")
    public String sayHello() {
        return "hello world \n" + serverPort;
    }
}
