/*
 * @projectName raladmin
 * @package com.ral.admin
 * @className com.ral.admin.Demo
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin;

import java.io.IOException;

import cn.hutool.core.util.IdUtil;

/**
 * Demo
 * @Description
 * @author renyunhui
 * @date 2021/3/2 17:31
 * @version 1.0
 */
public class Demo {

    public static void main(String[] args) throws IOException {
        System.err.println(IdUtil.fastSimpleUUID());
        String msg = "95e3f1a8136e40eaa0a4fd3399e2e463";

        String re = ".".replaceAll("\\.", "\\\\.");
        String re2 = ".".replace("\\.", ".");
        System.err.println(re);
        System.err.println(re2);

    }
}
