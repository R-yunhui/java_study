/**
 * @projectName study
 * @package org.example.ral.dao.domain
 * @className org.example.ral.dao.domain.UserDomain
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package org.example.ral.dao.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * UserDomain
 * @description 用户实体类 - 数据库user表映射
 * @author RenYunHui
 * @date 2020/9/1 10:55
 * @version 1.0
 */
@TableName(value = "user", schema = "public")
@Data
public class UserDomain {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "username")
    private String userName;

    @TableField(value = "password")
    private String passWord;

    @TableField(value = "real_name")
    private String realName;
}
