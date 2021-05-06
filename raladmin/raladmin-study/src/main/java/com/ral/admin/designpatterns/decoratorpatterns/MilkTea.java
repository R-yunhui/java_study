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
        return this.description;
    }

    @Override
    public int cost() {
        return 10;
    }
}
