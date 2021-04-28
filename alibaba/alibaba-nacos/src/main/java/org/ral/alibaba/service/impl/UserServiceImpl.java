/*
 * @projectName raladmin
 * @package org.ral.alibaba.service.impl
 * @className org.ral.alibaba.service.impl.UserServiceImpl
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package org.ral.alibaba.service.impl;

import org.ral.alibaba.common.BaseResult;
import org.ral.alibaba.ex.BusinessException;
import org.ral.alibaba.service.IUserService;
import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

/**
 * UserServiceImpl
 * @Description
 * @author renyunhui
 * @date 2021/4/28 11:44
 * @version 1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Override
    @SentinelResource(value = "findUserById", blockHandler = "businessExceptionHandler", fallback = "defaultFallBack")
    public String findUserById(int id) {
        if (0 == id) {
            log.info("根据用户ID:{}查询用户信息失败", id);
            throw new BusinessException("根据ID查询用户信息失败");
        }
        return "查询到符合条件的用户信息";
    }

    /**
     * 服务限流降级处理
     * @param id 参数
     * @param e 限流降级抛出的异常
     * @return 返回值
     */
    public String businessExceptionHandler(int id, BlockException e) {
        log.error("根据用户ID:{}查询用户信息失败,业务异常:{}", id, e);
        return JSON.toJSONString(BaseResult.failure(-1, "服务限流降级处理"));
    }

    /**
     * 服务熔断降级处理
     * @param id 参数
     * @param e 熔断降级抛出的异常
     * @return 返回值
     */
    public String defaultFallBack(String id, Exception e) {
        log.error("根据用户ID:{}查询用户信息失败,业务异常:{}", id, e);
        return JSON.toJSONString(BaseResult.failure(-1, "服务熔断降级处理"));
    }

}
