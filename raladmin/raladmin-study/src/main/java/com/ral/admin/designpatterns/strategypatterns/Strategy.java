package com.ral.admin.designpatterns.strategypatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-28 13:16
 * @Describe: 策略定义类
 * @Modify:
 */
public interface Strategy {

    /**
     * 计算价格
     * @param price 价格
     * @return 折后价格
     */
    double calculatePrice(double price);
}
