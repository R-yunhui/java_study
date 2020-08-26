/**
 * @projectName demo
 * @package com.example.ral.demo.controller
 * @className com.example.ral.demo.controller.WebController
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.example.ral.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ral.demo.service.WebService;

/**
 * WebController
 * @description WebController
 * @author RenYunHui
 * @date 2020/8/26 14:58
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/web")
public class WebController {

    @Resource
    private WebService webService;

    @GetMapping(value = "/uuid")
    public String uuid() {
        return webService.getUuid();
    }
}
