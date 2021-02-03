/*
 * @projectName raladmin
 * @package com.ral.admin.auth.controller
 * @className com.ral.admin.auth.controller.WebController
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ral.admin.auth.dao.RoleDao;
import com.ral.admin.auth.dao.UserDao;
import com.ral.admin.auth.pojo.RoleDo;
import com.ral.admin.auth.pojo.UserDo;

import cn.hutool.json.JSONUtil;

/**
 * WebController
 * @Description Web对外接口
 * @author renyunhui
 * @date 2021/2/2 11:26
 * @version 1.0
 */
@Controller
public class WebController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

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

    @GetMapping(value = "/testOne")
    @ResponseBody
    public void testOne() {
        UserDo userDo = userDao.findUserByUserName("admin");
        RoleDo roleDo = roleDao.findByRoleIds(new String[]{"f79e706c79704c84a3825f5a640845a0"});
        System.err.println(JSONUtil.toJsonStr(userDo) + "\n" + JSONUtil.toJsonStr(roleDo));
    }

    @GetMapping(value = "/testTwo")
    @ResponseBody
    public void testTwo() {
        UserDo userDo = userDao.findUserByUserName("admin");
        RoleDo roleDo = roleDao.findByRoleIds(new String[]{"f79e706c79704c84a3825f5a640845a0"});
        System.err.println(JSONUtil.toJsonStr(userDo) + "\n" + JSONUtil.toJsonStr(roleDo));
    }
}
