/*
 * @projectName raladmin
 * @package com.ral.admin.auth.config
 * @className com.ral.admin.auth.config.MybatisPlusConfig
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;

/**
 * MybatisPlusConfig
 * @Description mybatis分页插件配置
 * @author renyunhui
 * @date 2021/2/1 16:26
 * @version 1.0
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
