/*
 * @projectName raladmin
 * @package com.ral.admin.auth.handler
 * @className com.ral.admin.auth.handler.MyAuthenticationSuccessHandler
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.auth.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * MyAuthenticationSuccessHandler
 * @Description 处理登录失败的用户身份验证的策略
 * @author renyunhui
 * @date 2021/2/2 17:00
 * @version 1.0
 */
@Component
@Slf4j
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        log.info("登录失败");
        // http状态，200，成功
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSONUtil.toJsonStr(e));
    }
}
