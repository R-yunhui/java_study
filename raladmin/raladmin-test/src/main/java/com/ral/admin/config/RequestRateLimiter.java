///*
// * @projectName raladmin
// * @package com.ral.admin.config
// * @className com.ral.admin.config.RequestRateLimter
// * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
// */
//package com.ral.admin.config;
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//import java.util.concurrent.TimeUnit;
//
///**
// * RequestRateLimiter
// * @Description 请求限流注解
// * @author renyunhui
// * @date 2021/3/11 10:31
// * @version 1.0
// */
//@Target(ElementType.METHOD)
//@Retention(RetentionPolicy.RUNTIME)
//public @interface RequestRateLimiter {
//
//    /**
//     * 这里指吞吐率每秒多少许可数（通常是指QPS，每秒多少查询）
//     * @return qps
//     */
//    double qps() default 10D;
//
//    /**
//     * 获取令牌超时时间
//     * @return 令牌超时时间
//     */
//    long acquireTokenTimeout() default 100;
//
//    /**
//     * 获取令牌超时时间单位：默认为 毫秒
//     * @return 获取令牌超时时间单位
//     */
//    TimeUnit timeunit() default TimeUnit.MILLISECONDS;
//
//    /**
//     * 获取令牌失败提示
//     * @return 获取令牌失败提示
//     */
//    String resMsg() default "请求过于繁忙请稍后再试！";
//}
