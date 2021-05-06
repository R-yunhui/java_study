/*
 * @projectName raladmin
 * @package com.ral.admin.dao
 * @className com.ral.admin.dao.MqMsgDao
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ral.admin.pojo.MqMsgDo;

/**
 * MqMsgDao
 * @Description
 * @author renyunhui
 * @date 2021/4/9 16:23
 * @version 1.0
 */
@Mapper
public interface MqMsgDao extends BaseMapper<MqMsgDo> {
}
