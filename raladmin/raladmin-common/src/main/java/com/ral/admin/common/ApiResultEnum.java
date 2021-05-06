/*
 * @projectName raladmin
 * @package com.ral.admin.common
 * @className com.ral.admin.common.ApiResultEnum
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.common;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.ToString;

/**
 * ApiResultEnum
 * @Description Api接口定义枚举类
 * @author renyunhui
 * @date 2021/2/1 15:21
 * @version 1.0
 */
@ToString
@Getter
public enum ApiResultEnum {

    /** 请求成功 */
    SUCCESS(HttpStatus.OK, 200, "OK"),

    /** 请求错误 (语义错误或参数错误) */
    BAD_REQUEST(HttpStatus.BAD_REQUEST, 400, "语义错误或请求参数错误"),

    /** 服务器端异常 */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "Internal Server Error"),

    /** 认证失败 */
    AUTHENTICATION_FAILED(HttpStatus.FORBIDDEN, 403, "认证失败，用户名或密码错误"),

    /** 限流失败 */
    LIMIT_FAILED(HttpStatus.UNAUTHORIZED, 401, "请求过于繁忙请稍后再试！");

    /** HTTP 状态码 */
    HttpStatus status;

    /** 业务异常错误码 */
    int code;

    /** 业务异常消息描述 */
    String msg;

    ApiResultEnum(HttpStatus status, int code, String msg) {
        this.status = status;
        this.code = code;
        this.msg = msg;
    }
}
