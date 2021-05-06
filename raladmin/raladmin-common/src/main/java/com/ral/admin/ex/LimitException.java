/*
 * @projectName raladmin
 * @package com.ral.admin.ex
 * @className com.ral.admin.ex.LimitException
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.ex;

import com.ral.admin.common.ApiResultEnum;

import lombok.Getter;
import lombok.Setter;

/**
 * LimitException
 * @Description 限流异常
 * @author renyunhui
 * @date 2021/3/11 10:35
 * @version 1.0
 */
@Getter
@Setter
public class LimitException extends RuntimeException {

    private ApiResultEnum result;

    public LimitException(ApiResultEnum resultEnum) {
        this.result = resultEnum;
    }

    protected LimitException(ApiResultEnum resultEnum, Throwable cause) {
        super(cause);
        this.result = resultEnum;
    }
}
