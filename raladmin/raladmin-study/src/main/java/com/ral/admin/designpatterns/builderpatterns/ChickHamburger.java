/*
 * @projectName raladmin
 * @package com.ral.admin.designpatterns.builderpatterns
 * @className com.ral.admin.designpatterns.builderpatterns.ChickHamburger
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.designpatterns.builderpatterns;

/**
 * ChickHamburger
 * @Description 鸡腿堡
 * @author renyunhui
 * @date 2021/3/31 12:19
 * @version 1.0
 */
public class ChickHamburger extends Hamburger {

    @Override
    public String getName() {
        return "鸡腿堡";
    }

    @Override
    public int cost() {
        return 15;
    }
}
