/*
 * @projectName raladmin
 * @package com.ral.admin.redis.po
 * @className com.ral.admin.redis.po.UserPo
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.redis.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserPo
 * @Description
 * @author renyunhui
 * @date 2021/4/30 15:01
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPo {

    private int id;

    private String username;

    private String password;

    private int age;
}
