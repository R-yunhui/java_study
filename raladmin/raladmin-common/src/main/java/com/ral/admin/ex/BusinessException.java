/*
 * @projectName raladmin
 * @package com.ral.admin.ex
 * @className com.ral.admin.ex.BussinessException
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.ex;

import com.ral.admin.common.ApiResultEnum;

import lombok.Getter;
import lombok.Setter;

/**
 * BussinessException
 * @Description 业务异常
 * @author renyunhui
 * @date 2021/2/2 15:01
 * @version 1.0
 */
@Getter
@Setter
public class BusinessException extends RuntimeException {

    private ApiResultEnum result;

    public BusinessException(ApiResultEnum resultEnum) {
        this.result = resultEnum;
    }

    protected BusinessException(ApiResultEnum resultEnum, Throwable cause) {
        super(cause);
        this.result = resultEnum;
    }
}
