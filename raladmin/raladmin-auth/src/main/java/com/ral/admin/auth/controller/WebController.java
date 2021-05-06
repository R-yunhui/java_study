/*
 * @projectName raladmin
 * @package com.ral.admin.auth.controller
 * @className com.ral.admin.auth.controller.WebController
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * WebController
 * @Description Web对外接口
 * @author renyunhui
 * @date 2021/2/2 11:26
 * @version 1.0
 */
@Controller
public class WebController {

    @ResponseBody
    @GetMapping(value = "/sayHello")
    public String sayHello() {
        return "hello world";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = {"/index", "/"})
    public String index() {
        return "index";
    }
}
