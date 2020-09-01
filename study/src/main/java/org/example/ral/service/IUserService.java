/**
 * @projectName study
 * @package org.example.ral.service
 * @className org.example.ral.service.IUserService
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package org.example.ral.service;

import java.util.List;

import org.example.ral.dao.domain.UserDomain;

/**
 * IUserService
 * @description 用户业务层接口定义
 * @author RenYunHui
 * @date 2020/9/1 11:00
 * @version 1.0
 */
public interface IUserService {

    /**
     * 插入用户信息
     * @param userDomain 用户信息
     * @return 受影响的行数
     */
    int insertUser(UserDomain userDomain);

    /**
     * 查询所有用户信息
     * @return 查询出来的所有用户信息集合
     */
    List<UserDomain> selectAllUser();
}
