/*
 * @projectName raladmin
 * @package com.ral.admin.auth.handler
 * @className com.ral.admin.auth.handler.UrlFilterInvocationSecurityMetadataSourceHandler
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.auth.handler;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import com.ral.admin.auth.dao.AuthorityDao;
import com.ral.admin.auth.pojo.AuthorityDo;

/**
 * UrlFilterInvocationSecurityMetadataSourceHandler
 * @Description 获取访问url需要的角色权限信息
 * @author renyunhui
 * @date 2021/2/3 16:25
 * @version 1.0
 */
@Component
public class UrlFilterInvocationSecurityMetadataSourceHandler implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private AuthorityDao authorityDao;

    /***
     * 返回该url所需要的用户权限信息
     *
     * @param o: 储存请求url信息
     * @return 标识不需要任何权限都可以访问
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        // 获取当前请求url
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        // TODO 此处可以配置进行过滤的url

        // 数据库中所有的url
        List<AuthorityDo> authorityDoList = authorityDao.selectByMap(null);
        authorityDoList.stream().forEach(x -> {

        });

        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
