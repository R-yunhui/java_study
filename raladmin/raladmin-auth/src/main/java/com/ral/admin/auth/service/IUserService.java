/*
 * @projectName raladmin
 * @package com.ral.admin.auth.service
 * @className com.ral.admin.auth.service.IUserService
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.auth.service;

import com.ral.admin.auth.pojo.UserDo;

/**
 * IUserService
 * @Description 用户业务层接口
 * @author renyunhui
 * @date 2021/2/1 17:31
 * @version 1.0
 */
public interface IUserService {

    /**
     * 注册用户信息
     * @param userDo 用户信息实体
     * @return 注册成功的用户数量
     */
    Integer registerUserInfo(UserDo userDo);

    /**
     * 根据用户ID获取用户信息
     * @param userId 用户ID
     * @return 符合条件的用户信息
     */
    UserDo findUserInfo(String userId);

    /**
     * 用户通过用户名密码进行登录
     * @param username 用户名
     * @param password 密码
     */
    void userLogin(String username, String password);

}
