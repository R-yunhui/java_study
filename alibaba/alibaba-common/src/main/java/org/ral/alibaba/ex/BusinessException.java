/*
 * @projectName raladmin
 * @package org.ral.alibaba.ex
 * @className org.ral.alibaba.ex.BussinessException
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package org.ral.alibaba.ex;

/**
 * BussinessException
 * @Description
 * @author renyunhui
 * @date 2021/4/28 13:33
 * @version 1.0
 */
public class BusinessException extends Exception {

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    protected BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
