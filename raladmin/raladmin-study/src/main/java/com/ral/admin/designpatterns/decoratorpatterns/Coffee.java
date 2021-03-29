package com.ral.admin.designpatterns.decoratorpatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-29 21:40
 * @Describe:
 * @Modify:
 */
public class Coffee extends Beverage {

    public Coffee() {
        this.description = "咖啡";
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double cost() {
        return 5.0;
    }
}
