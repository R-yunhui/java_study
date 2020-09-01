/**
 * @projectName study
 * @package org.example.ral.controller
 * @className org.example.ral.controller.WebController
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package org.example.ral.controller;

import java.util.List;

import javax.annotation.Resource;

import org.example.ral.dao.domain.UserDomain;
import org.example.ral.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.json.JSONUtil;

/**
 * WebController
 * @description Web控制器层
 * @author RenYunHui
 * @date 2020/9/1 10:27
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/web")
public class WebController {

    @Resource
    private IUserService userService;

    @GetMapping(value = "/sayHello.do")
    public String sayHello() {
        return "hello docker";
    }

    @PostMapping(value = "/saveUser.do")
    public String user(@RequestBody UserDomain userDomain) {
        int row = userService.insertUser(userDomain);
        return "插入成功,插入行数为:" + row;
    }

    @GetMapping(value = "/queryAllUser.do")
    public String user() {
        List<UserDomain> userDomainList = userService.selectAllUser();
        return JSONUtil.toJsonStr(userDomainList);
    }
}
