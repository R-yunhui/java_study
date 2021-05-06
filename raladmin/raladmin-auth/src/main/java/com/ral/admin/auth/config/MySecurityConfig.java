/*
 * @projectName raladmin
 * @package com.ral.admin.auth.config
 * @className com.ral.admin.auth.config.MySecutityConfig
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ral.admin.auth.handler.MyAuthenticationFailureHandler;
import com.ral.admin.auth.handler.MyAuthenticationProvider;
import com.ral.admin.auth.handler.MyAuthenticationSuccessHandler;
import com.ral.admin.auth.handler.UrlAccessDecisionManager;
import com.ral.admin.auth.handler.UrlAccessDeniedHandler;
import com.ral.admin.auth.service.MyUserDetailServiceImpl;

/**
 * MySecurityConfig
 * @author 13653
 * @Description SpringSecurity配置类
 * @author renyunhui
 * @date 2021/2/2 11:38
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailServiceImpl userDetailService;
    @Autowired
    private MyAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private MyAuthenticationProvider authenticationProvider;
    @Autowired
    private UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    private UrlAccessDeniedHandler urlAccessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 开启跨域
        http.cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/index", "/").permitAll()
                .antMatchers("/sayHello").hasRole("admin")
                // 所有资源登录之后即可访问
                .anyRequest().authenticated()
                .and()
                // 登录配置
                .formLogin()
                // 登录页面
                .loginPage("/login")
                // 请求地址
                .loginProcessingUrl("/api/v1/user/userLogin")
                // 自定义登录成功失败的处理方式
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                // 默认的用户名,密码参数
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll();
    }

    /**
     * SpringSecurity 如何获取用户信息，找到用户列表
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 自定义MyAuthenticationProvider 装配到 AuthenticationManagerBuilder中
        auth.authenticationProvider(authenticationProvider)
                // 自行使用认证名称来查找对应的用户数据，然后交给Spring Security使用
                .userDetailsService(userDetailService)
                .passwordEncoder(passwordEncoder());
    }

    /** 密码加密方式 */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
