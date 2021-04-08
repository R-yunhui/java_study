/*
 * @projectName raladmin
 * @package com.ral.admin.designpatterns.builderpatterns
 * @className com.ral.admin.designpatterns.builderpatterns.BeafHambuger
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.designpatterns.builderpatterns;

/**
 * BeafHambuger
 * @Description 牛肉煲
 * @author renyunhui
 * @date 2021/3/31 12:20
 * @version 1.0
 */
public class BeefHamburger extends Hamburger {

    @Override
    public String getName() {
        return "牛肉煲";
    }

    @Override
    public int cost() {
        return 20;
    }
}
