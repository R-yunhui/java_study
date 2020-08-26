/**
 * @projectName demo
 * @package com.example.ral.demo.service
 * @className com.example.ral.demo.service.WebService
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.example.ral.demo.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

/**
 * WebService
 * @description WebService
 * @author RenYunHui
 * @date 2020/8/26 14:59
 * @version 1.0
 */
@Service
public class WebService {

    public String getUuid() {

        return UUID.randomUUID().toString().toLowerCase();
    }
}
