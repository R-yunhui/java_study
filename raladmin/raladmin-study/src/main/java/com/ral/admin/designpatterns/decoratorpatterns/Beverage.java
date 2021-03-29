package com.ral.admin.designpatterns.decoratorpatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-29 21:35
 * @Describe: 饮料的抽象类
 * @Modify:
 */
public abstract class Beverage {

    /**
     * 饮料的描述
     */
    protected String description;

    public Beverage() {
        this.description = "饮料的抽象类";
    }

    public String getDescription() {
        return description;
    }

    /**
     * 支付方法
     * @return 价格
     */
    public abstract double cost();
}
