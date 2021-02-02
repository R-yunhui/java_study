package com.ral.admin.auth.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ral.admin.auth.pojo.RoleDo;

/**
 * RoleDao
 * @Description RoleDao 角色信息持久层接口
 * @author renyunhui
 * @date 2021/2/1 15:50
 * @version 1.0
 */
public interface RoleDao extends BaseMapper<RoleDo> {

    /**
     * 根据角色ID 查询权限信息
     * @param roleIds 角色D集合
     * @return 匹配的权限信息
     */
    RoleDo findByRoleIds(String[] roleIds);

}