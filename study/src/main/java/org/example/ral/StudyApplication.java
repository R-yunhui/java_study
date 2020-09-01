/**
 * @projectName study
 * @package org.example.ral
 * @className org.example.ral.StudyApplication
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package org.example.ral;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * StudyApplication
 * @description docker学习模块启动类
 * @author RenYunHui
 * @date 2020/9/1 10:21
 * @version 1.0
 */
@SpringBootApplication
@MapperScan(value = "org.example.ral.dao")
public class StudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }
}
