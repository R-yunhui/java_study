/*
 * @projectName raladmin
 * @package com.ral.admin.auth.handler
 * @className com.ral.admin.auth.handler.UrlAccessDecisionManager
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.auth.handler;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

/**
 * UrlAccessDecisionManager
 * @Description 对于url进行权限验证
 * @author renyunhui
 * @date 2021/2/3 16:36
 * @version 1.0
 */
@Component
public class UrlAccessDecisionManager implements AccessDecisionManager {

    /**
     * @param authentication: 当前登录用户的角色信息
     * @param o: 请求url信息
     * @param collection: `UrlFilterInvocationSecurityMetadataSource`中的getAttributes方法传来的，表示当前请求需要的角色（可能有多个）
     * @return: void
     */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        // 遍历角色
        for (ConfigAttribute ca : collection) {
            // 当前url请求需要的权限
            String needRole = ca.getAttribute();
//            if (Constants.ROLE_LOGIN.equals(needRole)) {
//                if (authentication instanceof AnonymousAuthenticationToken) {
//                    throw new BadCredentialsException("未登录!");
//                } else {
//                    throw new AccessDeniedException("未授权该url！");
//                }
//            }

            // 当前用户所具有的角色
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                // 只要包含其中一个角色即可访问
                if (authority.getAuthority().equals(needRole)) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("请联系管理员分配权限！");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
