/*
 * @projectName raladmin
 * @package com.ral.admin.auth.pojo.bo
 * @className com.ral.admin.auth.pojo.bo.UserDetailsBo
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.auth.pojo.bo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ral.admin.auth.pojo.UserDo;

import lombok.Data;

/**
 * UserDetailsBo
 * @Description: UserDetails是真正用于构建SpringSecurity登录的安全用户(UserDetails)
 * 在SpringSecurity进行用户认证的过程中，是通过UserDetails的实现类去获取用户信息，然后进行授权验证的
 *
 * @author renyunhui
 * @date 2021/2/3 9:57
 * @version 1.0
 */
@Data
public class UserDetailsBo extends UserDo implements UserDetails {

    public UserDetailsBo(UserDo userDo) {
        if (null != userDo) {
            this.setUserId(userDo.getUserId());
            this.setRoleIds(userDo.getRoleIds());
            this.setUserName(userDo.getUserName());
            this.setPassWord(userDo.getPassWord());
            this.setAge(userDo.getAge());
            this.setGender(userDo.getAge());
            this.setEmail(userDo.getEmail());
            this.setPhoneNumber(userDo.getPhoneNumber());
            this.setStatus(userDo.getAge());
            this.setRoleDoList(userDo.getRoleDoList());
            this.setAuthorityDoList(userDo.getAuthorityDoList());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthorityDoList();
    }

    @Override
    public String getPassword() {
        return getPassWord();
    }

    @Override
    public String getUsername() {
        return getUserName();
    }

    /** 账户是否过期 */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /** 账户是否被锁定 */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /** 认证是否过期 */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /** 是否不可用 */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
