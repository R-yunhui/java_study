/*
 * @projectName raladmin
 * @package org.ral.alibaba.service
 * @className org.ral.alibaba.service.UserService
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package org.ral.alibaba.service;

import org.ral.alibaba.ex.BusinessException;

/**
 * UserService
 * @Description
 * @author renyunhui
 * @date 2021/4/28 11:44
 * @version 1.0
 */
public interface IUserService {

    /**
     * 根据用户ID查询用户信息
     * @param id 用户ID
     * @return 符合条件的用户信息
     */
    String findUserById(int id);
}
