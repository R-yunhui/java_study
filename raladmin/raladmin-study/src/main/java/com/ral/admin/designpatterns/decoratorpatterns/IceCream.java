/*
 * @projectName raladmin
 * @package com.ral.admin.designpatterns.decoratorpatterns
 * @className com.ral.admin.designpatterns.decoratorpatterns.IceCream
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.designpatterns.decoratorpatterns;

/**
 * IceCream
 * @Description 冰淇淋 装饰者
 * @author renyunhui
 * @date 2021/3/30 9:28
 * @version 1.0
 */
public class IceCream extends Ingredients {

    /** 被装饰者 */
    private Beverage beverage;

    /** 装饰被装饰着 */
    public IceCream(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return "冰淇淋" + beverage.getDescription();
    }

    @Override
    public int cost() {
        return 5 + beverage.cost();
    }
}
