package com.ral.admin.designpatterns.decoratorpatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-29 21:43
 * @Describe: 椰果配料 装饰者
 * @Modify:
 */
public class Coconut extends Ingredients {

    /** 被装饰者 */
    private Beverage beverage;

    /** 装饰被装饰着 */
    public Coconut(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return "椰果" + beverage.getDescription();
    }

    @Override
    public double cost() {
        return 1.0 + beverage.cost();
    }
}
