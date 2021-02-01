/*
 * @projectName raladmin
 * @package com.ral.admin.common
 * @className com.ral.admin.common.BaseResult
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
 * BaseResult
 * @Description Api接口统一返回实体
 * @author renyunhui
 * @date 2021/2/1 15:16
 * @version 1.0
 */
@Getter
@ApiModel(value = "Api接口统一返回实体")
public class BaseResult<T> {

    /** 业务异常错误码 */
    @ApiModelProperty(value = "业务异常错误码")
    private Integer code;

    /** 业务异常消息描述 */
    @ApiModelProperty(value = "业务异常消息描述")
    private String message;

    /** 返回参数 */
    @ApiModelProperty(value = "返回参数")
    private T data;

    private BaseResult(ApiResultEnum resultStatus, T data) {
        this.code = resultStatus.getCode();
        this.message = resultStatus.getMsg();
        this.data = data;
    }

    /** 业务成功返回业务代码和描述信息 */
    public static BaseResult<Void> success() {
        return new BaseResult<>(ApiResultEnum.SUCCESS, null);
    }

    /** 业务成功返回业务代码,描述和返回的参数 */
    public static <T> BaseResult<T> success(T data) {
        return new BaseResult<>(ApiResultEnum.SUCCESS, data);
    }

    /** 业务成功返回业务代码,描述和返回的参数 */
    public static <T> BaseResult<T> success(ApiResultEnum resultStatus, T data) {
        if (resultStatus == null) {
            return success(data);
        }
        return new BaseResult<>(resultStatus, data);
    }

    /** 业务异常返回业务代码和描述信息 */
    public static <T> BaseResult<T> failure() {
        return new BaseResult<>(ApiResultEnum.INTERNAL_SERVER_ERROR, null);
    }

    /** 业务异常返回业务代码,描述和返回的参数 */
    public static <T> BaseResult<T> failure(ApiResultEnum resultStatus) {
        return failure(resultStatus, null);
    }

    /** 业务异常返回业务代码,描述和返回的参数 */
    public static <T> BaseResult<T> failure(ApiResultEnum resultStatus, T data) {
        if (resultStatus == null) {
            return new BaseResult<>(ApiResultEnum.INTERNAL_SERVER_ERROR, null);
        }
        return new BaseResult<>(resultStatus, data);
    }

}
