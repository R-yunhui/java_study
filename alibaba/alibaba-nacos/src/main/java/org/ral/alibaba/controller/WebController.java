/*
 * @projectName raladmin
 * @package org.ral.alibaba.controller
 * @className org.ral.alibaba.controller.WebController
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package org.ral.alibaba.controller;

import org.ral.alibaba.common.BaseResult;
import org.ral.alibaba.ex.BusinessException;
import org.ral.alibaba.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * WebController
 * @Description
 * @author renyunhui
 * @date 2021/4/28 11:30
 * @version 1.0
 */
@RestController
public class WebController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/findUserById/{id}")
    public BaseResult<String> findUserById(@PathVariable(value = "id") int id) {
        return BaseResult.success(userService.findUserById(id));
    }
}
