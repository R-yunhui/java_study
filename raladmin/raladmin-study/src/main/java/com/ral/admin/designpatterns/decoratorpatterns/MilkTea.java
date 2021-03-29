package com.ral.admin.designpatterns.decoratorpatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-29 21:42
 * @Describe:
 * @Modify:
 */
public class MilkTea extends Beverage {

    public MilkTea() {
        this.description = "奶茶";
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double cost() {
        return 7.0;
    }
}
