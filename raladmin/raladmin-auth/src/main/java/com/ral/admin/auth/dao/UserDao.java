package com.ral.admin.auth.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ral.admin.auth.pojo.UserDo;

/**
 * UserDao
 * @Description: 用户信息持久层接口
 *
 * @author renyunhui
 * @date 2021/2/3 9:57
 * @version 1.0
 */
public interface UserDao extends BaseMapper<UserDo> {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 匹配的用户信息
     */
    UserDo findUserByUserName(String username);

}