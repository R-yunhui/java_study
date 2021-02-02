/*
 * @projectName raladmin
 * @package com.ral.admin.auth.handler
 * @className com.ral.admin.auth.handler.GloablExceptionHandler
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.auth.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ral.admin.common.ApiResultEnum;
import com.ral.admin.common.BaseResult;
import com.ral.admin.ex.BusinessException;

/**
 * GloablExceptionHandler
 * @Description 全局异常处理
 * @author renyunhui
 * @date 2021/2/2 15:38
 * @version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 统一处理post请求的参数校验异常
     * @param e 请求参数验证失败异常
     * @return 接口统一返回实体
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public BaseResult<Map<String, String>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errorMap = dealExceptionMsg(e.getBindingResult());
        return BaseResult.failure(ApiResultEnum.BAD_REQUEST, errorMap);
    }

    /**
     * 统一处理 ResourceTreeException 的异常
     * @param e 业务异常
     * @return 接口统一返回实体
     */
    @ExceptionHandler(value = {BusinessException.class})
    public BaseResult<BusinessException> handlerResourceTreeException(BusinessException e) {
        return BaseResult.failure(e.getResult(), e);
    }

    private Map<String, String> dealExceptionMsg(BindingResult result) {
        List<FieldError> errors = result.getFieldErrors();
        Map<String, String> errorMap = new HashMap<>(16);
        errors.forEach(x -> errorMap.put(x.getField(), x.getDefaultMessage()));
        return errorMap;
    }
}
