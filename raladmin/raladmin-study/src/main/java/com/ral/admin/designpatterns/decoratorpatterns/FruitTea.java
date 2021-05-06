/*
 * @projectName raladmin
 * @package com.ral.admin.designpatterns.decoratorpatterns
 * @className com.ral.admin.designpatterns.decoratorpatterns.FruitTea
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.designpatterns.decoratorpatterns;

/**
 * FruitTea
 * @Description 果茶
 * @author renyunhui
 * @date 2021/3/30 9:25
 * @version 1.0
 */
public class FruitTea extends Beverage {

    public FruitTea() {
        this.description = "果茶";
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int cost() {
        return 15;
    }
}
