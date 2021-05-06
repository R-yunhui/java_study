/*
 * @projectName raladmin
 * @package com.ral.admin.controller
 * @className com.ral.admin.controller.WebController
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ral.admin.handler.MqHandler;

/**
 * WebController
 * @Description
 * @author renyunhui
 * @date 2021/4/9 15:35
 * @version 1.0
 */
@RestController
public class WebController {

    @Resource
    private MqHandler mqHandler;

    @PostMapping(value = "/testMq")
    public void testMq(@RequestParam(value = "exchange") String exchange, @RequestParam(value = "routeKey") String routeKey,@RequestParam(value = "msg") String msg) {
        mqHandler.sendMsg(exchange, routeKey, msg);
    }

    @GetMapping(value = "/sayHello")
    public String sayHello() {
        return "hello world";
    }
}
