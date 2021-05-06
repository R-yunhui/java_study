/*
 * @projectName raladmin
 * @package com.ral.admin.stream
 * @className com.ral.admin.stream.UserPo
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.stream;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserPo
 * @Description
 * @author renyunhui
 * @date 2021/4/30 15:10
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPo {

    /** 用户ID */
    private int id;

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /** 生日 */
    private Date birthday;

    /** 年龄 */
    private int age;

    /** 性别 */
    private int gender;

    /** 工资 */
    private int wage;

    /** 奖金 */
    private int bonus;
}
