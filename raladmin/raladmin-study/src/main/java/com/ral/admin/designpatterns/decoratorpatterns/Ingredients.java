package com.ral.admin.designpatterns.decoratorpatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-29 21:37
 * @Describe: 配料的抽象类 配料的装饰者需要继承自饮料的抽象类
 * @Modify:
 */
public abstract class Ingredients extends Beverage {

    /**
     * 所有装饰者需要重写
     * @return 描述信息
     */
    @Override
    public abstract String getDescription();

    /**
     * 所有装饰者需要重写
     * @return 描述信息
     */
    @Override
    public abstract int cost();
}
