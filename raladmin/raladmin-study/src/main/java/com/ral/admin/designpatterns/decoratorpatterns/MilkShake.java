package com.ral.admin.designpatterns.decoratorpatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-29 21:40
 * @Describe: 奶昔
 * @Modify:
 */
public class MilkShake extends Beverage {

    public MilkShake() {
        this.description = "奶昔";
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int cost() {
        return 20;
    }
}
