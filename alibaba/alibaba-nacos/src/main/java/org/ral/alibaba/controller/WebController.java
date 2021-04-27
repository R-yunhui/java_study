/*
 * @projectName raladmin
 * @package org.ral.alibaba.controller
 * @className org.ral.alibaba.controller.WebController
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package org.ral.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * WebController
 * @Description
 * @author renyunhui
 * @date 2021/4/27 16:49
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/v1/web")
public class WebController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/sayPort")
    public String sayPort() {
        return "hello world - " + serverPort;
    }

}
