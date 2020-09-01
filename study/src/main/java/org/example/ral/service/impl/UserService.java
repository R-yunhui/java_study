/**
 * @projectName study
 * @package org.example.ral.service.impl
 * @className org.example.ral.service.impl.UserService
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package org.example.ral.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.example.ral.dao.UserDao;
import org.example.ral.dao.domain.UserDomain;
import org.example.ral.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * UserService
 * @description 用户业务层接口实现类
 * @author RenYunHui
 * @date 2020/9/1 11:01
 * @version 1.0
 */
@Service(value = "userService")
public class UserService implements IUserService {

    @Resource
    private UserDao userDao;

    @Override
    public int insertUser(UserDomain userDomain) {
        int row = userDao.insert(userDomain);
        return row;
    }

    @Override
    public List<UserDomain> selectAllUser() {
        return userDao.selectList(null);
    }
}
