/*
 * @projectName raladmin
 * @package com.ral.admin.pojo
 * @className com.ral.admin.pojo.MqMsgDo
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MqMsgDo
 * @Description
 * @author renyunhui
 * @date 2021/4/9 16:24
 * @version 1.0
 */
@TableName(value = "mq_test")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MqMsgDo {

    /** 主键自增ID */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /** 消息ID */
    @TableField(value = "msg_id")
    private String msgId;

    /** 消息 */
    @TableField(value = "msg")
    private String msg;
}
