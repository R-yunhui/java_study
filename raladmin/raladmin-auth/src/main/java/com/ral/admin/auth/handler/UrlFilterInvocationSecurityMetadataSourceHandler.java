///*
// * @projectName raladmin
// * @package com.ral.admin.auth.handler
// * @className com.ral.admin.auth.handler.UrlFilterInvocationSecurityMetadataSourceHandler
// * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
// */
//package com.ral.admin.auth.handler;
//
//import java.util.Collection;
//
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.web.FilterInvocation;
//import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
//import org.springframework.stereotype.Component;
//
///**
// * UrlFilterInvocationSecurityMetadataSourceHandler
// * @Description 获取访问url需要的角色权限信息
// * @author renyunhui
// * @date 2021/2/3 16:25
// * @version 1.0
// */
//@Component
//public class UrlFilterInvocationSecurityMetadataSourceHandler implements FilterInvocationSecurityMetadataSource {
//
//
//    /***
//     * 返回该url所需要的用户权限信息
//     *
//     * @param o: 储存请求url信息
//     * @return 标识不需要任何权限都可以访问
//     */
//    @Override
//    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
//        return null;
//    }
//
//    @Override
//    public Collection<ConfigAttribute> getAllConfigAttributes() {
//        return null;
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return FilterInvocation.class.isAssignableFrom(aClass);
//    }
//}
