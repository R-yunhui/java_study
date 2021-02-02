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

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * MyAuthenticationSuccessHandler
 * @Description 处理成功登录的用户身份验证的策略
 * @author renyunhui
 * @date 2021/2/2 17:00
 * @version 1.0
 */
@Component
@Slf4j
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("登录成功");
        response.setContentType("application/json;charset=utf-8");
        // writeValueAsString：将java对象序列化为字符串
        response.getWriter().write(JSONUtil.toJsonStr(authentication));
    }
}
