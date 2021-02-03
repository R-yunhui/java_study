/*
 * @projectName raladmin
 * @package com.ral.admin.auth.handler
 * @className com.ral.admin.auth.handler.MyAuthenticationProvider
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.auth.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.ral.admin.auth.pojo.bo.UserDetailsBo;
import com.ral.admin.auth.service.MyUserDetailServiceImpl;
import com.ral.admin.common.ApiResultEnum;
import com.ral.admin.ex.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * MyAuthenticationProvider
 * @Description 自定义认证器
 * @author renyunhui
 * @date 2021/2/3 10:23
 * @version 1.0
 */
@Component
@Slf4j
public class MyAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private MyUserDetailServiceImpl userDetailService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        return null;
    }

    /**
     * 实现用户认证的方法
     * @param authentication 认证信息
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取用户名 密码
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // 通过WebAuthenticationDetailsHandler获取用户输入的验证码信息
        UserDetailsBo userDetailsBo = (UserDetailsBo) userDetailService.loadUserByUsername(username);
        if (!password.equals(userDetailsBo.getPassword())) {
            log.info("用户输入的密码错误");
            throw new BusinessException(ApiResultEnum.AUTHENTICATION_FAILED);
        }

        // 将用户信息塞到SecurityContext中，方便获取当前用户信息
        return this.createSuccessAuthentication(userDetailsBo, authentication, userDetailsBo);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
