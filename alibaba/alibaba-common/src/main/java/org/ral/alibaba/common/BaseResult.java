/*
 * @projectName raladmin
 * @package org.ral.alibaba.common
 * @className org.ral.alibaba.common.BaseResult
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package org.ral.alibaba.common;

import lombok.Data;

/**
 * BaseResult
 * @Description
 * @author renyunhui
 * @date 2021/4/28 11:32
 * @version 1.0
 */
@Data
public class BaseResult<T> {

    /** 业务异常错误码 */
    private int code;

    /** 业务异常消息描述 */
    private String message;

    /** 返回参数 */
    private T data;

    private BaseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /** 业务成功返回业务代码和描述信息 */
    public static BaseResult<Void> success() {
        return new BaseResult<>(200, "success", null);
    }

    /** 业务成功返回业务代码,描述和返回的参数 */
    public static <T> BaseResult<T> success(T data) {
        return new BaseResult<>(200, "success", data);
    }

    /** 业务异常返回业务代码和描述信息 */
    public static <T> BaseResult<T> failure(int code, String message) {
        return new BaseResult<>(code, message, null);
    }

    /** 业务异常返回业务代码,描述和返回的参数 */
    public static <T> BaseResult<T> failure(int code, String message, T data) {
        return new BaseResult<>(code, message, data);
    }

}
