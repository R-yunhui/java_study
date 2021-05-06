/*
 * @projectName raladmin
 * @package com.ral.admin.designpatterns.builderpatterns
 * @className com.ral.admin.designpatterns.builderpatterns.Hamburger
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.designpatterns.builderpatterns;

/**
 * Hamburger
 * @Description 汉堡抽象类
 * @author renyunhui
 * @date 2021/3/31 12:16
 * @version 1.0
 */
public abstract class Hamburger implements Food {

    @Override
    public Package getPackage() {
        return new Carton();
    }

    /**
     * 支付
     * @return 支付的价格
     */
    @Override
    public abstract int cost();
}
