/**
 * @projectName study
 * @package org.example.ral.dao
 * @className org.example.ral.dao.UserDao
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package org.example.ral.dao;

import org.example.ral.dao.domain.UserDomain;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * UserDao
 * @description 用户数据层接口定义
 * @author RenYunHui
 * @date 2020/9/1 10:55
 * @version 1.0
 */
public interface UserDao extends BaseMapper<UserDomain> {
}
