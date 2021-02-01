/*
 * @projectName raladmin
 * @package com.ral.admin.auth.service.impl
 * @className com.ral.admin.auth.service.impl.UserServiceImpl
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.auth.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ral.admin.auth.dao.UserDao;
import com.ral.admin.auth.pojo.UserDo;
import com.ral.admin.auth.service.IUserService;
import com.ral.admin.common.CommonDefine;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * UserServiceImpl
 * @Description 用户业务层接口实现类
 * @author renyunhui
 * @date 2021/2/1 17:32
 * @version 1.0
 */
@Service(value = "userServiceImpl")
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer registerUserInfo(UserDo userDo) {
        Date date = new Date();
        userDo.setUserId(IdUtil.fastSimpleUUID());
        userDo.setCreateUser("admin");
        userDo.setUpdateUser("admin");
        userDo.setCreateTime(date);
        userDo.setUpdateTime(date);
        userDo.setModifyMethod(CommonDefine.LAST_MODIFIED_METHOD_CREATE);
        return userDao.insert(userDo);
    }

    @Override
    public UserDo findUserInfo(String userId) {
        return userDao.selectById(userId);
    }

    @Override
    public void userLogin(String username, String password) {
        Map<String, Object> paramMap = new HashMap<>(2);
        paramMap.put("user_name", username);
        paramMap.put("pass_word", password);
        List<UserDo> userDoList = userDao.selectByMap(paramMap);
        log.info("登录成功,登录的用户信息为：{}", JSONUtil.toJsonStr(userDoList));
    }
}
