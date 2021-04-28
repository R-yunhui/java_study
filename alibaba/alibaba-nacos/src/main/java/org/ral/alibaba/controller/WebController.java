/*
 * @projectName raladmin
 * @package org.ral.alibaba.controller
 * @className org.ral.alibaba.controller.WebController
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package org.ral.alibaba.controller;

import org.ral.alibaba.common.BaseResult;
import org.ral.alibaba.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * WebController
 *
 * @author renyunhui
 * @version 1.0
 * @Description
 * @date 2021/4/28 11:30
 */
@RestController
@RefreshScope
public class WebController {

    @Autowired
    private IUserService userService;

    @Value("${user.name}")
    private String username;

    @GetMapping(value = "/findUserById/{id}")
    public BaseResult<String> findUserById(@PathVariable(value = "id") int id) {
        return BaseResult.success(userService.findUserById(id) + "  " + username);
    }

    @GetMapping(value = "/getUserInfoByConfig")
    public BaseResult<String> getUserInfoByConfig() {
        return BaseResult.success("从nacos获取的配置的用户姓名为：" + username);
    }
}
