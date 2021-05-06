/*
 * @projectName raladmin
 * @package com.ral.admin
 * @className com.ral.admin.MqApplication
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MqApplication
 * @Description
 * @author renyunhui
 * @date 2021/4/9 13:54
 * @version 1.0
 */
@SpringBootApplication
@MapperScan(value = "com.ral.admin.dao")
public class MqApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqApplication.class, args);
    }
}
