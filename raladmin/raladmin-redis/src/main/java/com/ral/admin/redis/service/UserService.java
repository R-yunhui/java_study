/*
 * @projectName raladmin
 * @package com.ral.admin.redis.service
 * @className com.ral.admin.redis.service.UserService
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * UserService
 * @Description
 * @author renyunhui
 * @date 2021/4/30 14:59
 * @version 1.0
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
}
