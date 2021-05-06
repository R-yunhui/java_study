///*
// * @projectName raladmin
// * @package com.ral.admin.handler
// * @className com.ral.admin.handler.ExceptionHandler
// * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
// */
//package com.ral.admin.handler;
//
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import com.ral.admin.common.ApiResultEnum;
//import com.ral.admin.common.BaseResult;
//import com.ral.admin.ex.LimitException;
//
//import lombok.extern.slf4j.Slf4j;
//
///**
// * ExceptionHandler
// * @Description 异常处理
// * @author renyunhui
// * @date 2021/3/11 10:36
// * @version 1.0
// */
//@RestControllerAdvice
//@Slf4j
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(value = LimitException.class)
//    public BaseResult<String> handlerLimitException(LimitException e) {
//        log.error("限流失败,", e);
//        return BaseResult.failure(ApiResultEnum.LIMIT_FAILED);
//    }
//}
