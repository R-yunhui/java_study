package com.ral.admin.designpatterns.decoratorpatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-29 21:44
 * @Describe: 红豆配料 装饰者
 * @Modify:
 */
public class RedBeans extends Ingredients {

    /** 被装饰着 */
    private Beverage beverage;

    /** 装饰被装饰着 */
    public RedBeans(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return "红豆" + beverage.getDescription();
    }

    @Override
    public int cost() {
        return 2 + beverage.cost();
    }
}
