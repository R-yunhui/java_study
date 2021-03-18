/*
 * @projectName raladmin
 * @package com.ral.admin
 * @className com.ral.admin.TestApplication
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * TestApplication
 * @Description
 * @author renyunhui
 * @date 2021/3/9 15:26
 * @version 1.0
 */
@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
