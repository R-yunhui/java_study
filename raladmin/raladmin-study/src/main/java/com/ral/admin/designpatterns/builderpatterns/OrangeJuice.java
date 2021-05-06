/*
 * @projectName raladmin
 * @package com.ral.admin.designpatterns.builderpatterns
 * @className com.ral.admin.designpatterns.builderpatterns.Cola
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.designpatterns.builderpatterns;

/**
 * Cola
 * @Description 橙汁
 * @author renyunhui
 * @date 2021/3/31 12:22
 * @version 1.0
 */
public class OrangeJuice extends Beverage {

    @Override
    public String getName() {
        return "橙汁";
    }

    @Override
    public int cost() {
        return 8;
    }
}
