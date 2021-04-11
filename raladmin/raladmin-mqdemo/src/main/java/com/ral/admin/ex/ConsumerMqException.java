package com.ral.admin.ex;

/**
 * @Author: RenYunHui
 * @Date: 2021-04-11 13:52
 * @Describe: mq数据消费异常
 * @Modify:
 */
public class ConsumerMqException extends Exception {

    public ConsumerMqException(String message) {
        super(message);
    }
}
