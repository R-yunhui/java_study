/*
 * @projectName raladmin
 * @package com.ral.admin.designpatterns.decoratorpatterns
 * @className com.ral.admin.designpatterns.decoratorpatterns.Pearl
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.designpatterns.decoratorpatterns;

/**
 * Pearl
 * @Description 珍珠 装饰者
 * @author renyunhui
 * @date 2021/3/30 9:30
 * @version 1.0
 */
public class Pearl extends Ingredients {

    /** 被装饰者 */
    private Beverage beverage;

    /** 装饰被装饰着 */
    public Pearl(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return "珍珠" + beverage.getDescription();
    }

    @Override
    public int cost() {
        return 1 + beverage.cost();
    }
}
