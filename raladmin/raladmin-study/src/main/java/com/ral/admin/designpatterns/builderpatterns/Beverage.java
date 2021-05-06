/*
 * @projectName raladmin
 * @package com.ral.admin.designpatterns.builderpatterns
 * @className com.ral.admin.designpatterns.builderpatterns.Beverage
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.designpatterns.builderpatterns;

/**
 * Beverage
 * @Description 饮料抽象类
 * @author renyunhui
 * @date 2021/3/31 12:21
 * @version 1.0
 */
public abstract class Beverage implements Food {

    @Override
    public Package getPackage() {
        return new Bottle();
    }

    /**
     * 支付
     * @return 价格
     */
    @Override
    public abstract int cost();
}
