/*
 * @projectName raladmin
 * @package com.ral.admin.auth.controller
 * @className com.ral.admin.auth.controller.UserController
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ral.admin.auth.pojo.UserDo;
import com.ral.admin.auth.service.IUserService;
import com.ral.admin.common.BaseResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * UserController
 * @Description 用户相关接口
 * @author renyunhui
 * @date 2021/2/1 17:14
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/v1/user")
@Api(tags = "用户相关接口", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "注册用户信息", response = BaseResult.class)
    @ApiImplicitParam(name = "用户信息实体", value = "注册的用户信息", required = true, paramType = "body")
    @PostMapping(value = "/registerUserInfo")
    @ApiResponses({
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 400, message = "请求参数存在异常"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    public BaseResult<String> registerUserInfo(@RequestBody UserDo userDo) {
        int successCount = userService.registerUserInfo(userDo);
        return BaseResult.success("用戶信息注册成功,注册数量成功数量为:" + successCount);
    }

    @ApiOperation(value = "根据用户ID获取用户信息", response = BaseResult.class)
    @ApiImplicitParam(name = "用户ID", value = "注册的用户ID,唯一标识", required = true, paramType = "path", dataType = "String")
    @GetMapping(value = "/getUserInfo/{userId}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 400, message = "请求参数存在异常"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    public BaseResult<UserDo> getUserInfo(@PathVariable(value = "userId") String userId) {
        UserDo userDo = userService.findUserInfoByUserId(userId);
        return BaseResult.success(userDo);
    }

    @ApiOperation(value = "用户通过账号密码进行登录", response = BaseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "用户账号名", value = "注册的用户账号名", required = true, paramType = "path", dataType = "String"),
            @ApiImplicitParam(name = "用户密码", value = "注册的用户密码", required = true, paramType = "path", dataType = "String")
    })
    @PostMapping(value = "/userLogin")
    @ApiResponses({
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 400, message = "请求参数存在异常"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    public BaseResult<String> userLogin(String username, String password) {
        userService.userLogin(username, password);
        return BaseResult.success("登录成功");
    }
}
