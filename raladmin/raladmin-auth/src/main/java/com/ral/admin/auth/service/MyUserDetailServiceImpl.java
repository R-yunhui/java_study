/*
 * @projectName raladmin
 * @package com.ral.admin.auth.service
 * @className com.ral.admin.auth.service.MyUserDetailService
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.ral.admin.auth.dao.RoleDao;
import com.ral.admin.auth.pojo.RoleDo;
import com.ral.admin.auth.pojo.UserDo;
import com.ral.admin.common.ApiResultEnum;
import com.ral.admin.ex.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * MyUserDetailService
 * @Description 仔仔特定的用户信息
 * @author renyunhui
 * @date 2021/2/2 11:46
 * @version 1.0
 */
@Service
@Slf4j
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;
    @Autowired
    private RoleDao roleDao;

    /**
     * 通过用户名加载用户信息
     * 授权的时候是对角色授权，而认证的时候应该基于资源，而不是角色，因为资源是不变的，而用户的角色是会变的
     * @param username 用户名
     * @return 用户信息
     * @throws BusinessException 用户名不匹配异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        // 获取用户对应的角色信息
        UserDo userDo = userService.findUserInfoByUserName(username);
        if (null == userDo) {
            log.error("根据输入的用户名未查询到对应的用户信息,请重试");
            throw new BusinessException(ApiResultEnum.AUTHENTICATION_FAILED);
        }

        // 根据用户所含的角色信息查询对应的权限信息
        RoleDo roleDo = roleDao.findByRoleIds(userDo.getRoleIds().split(","));
        userDo.setAuthorityDoList(roleDo.getAuthorityDoList());
        return userDo;
    }
}
