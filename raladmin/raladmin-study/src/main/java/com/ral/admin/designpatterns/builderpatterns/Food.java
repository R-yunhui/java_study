/*
 * @projectName raladmin
 * @package com.ral.admin.designpatterns.builderpatterns
 * @className com.ral.admin.designpatterns.builderpatterns.Food
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.designpatterns.builderpatterns;

/**
 * Food
 * @Description 食品的接口
 * @author renyunhui
 * @date 2021/3/31 9:00
 * @version 1.0
 */
public interface Food {

    /**
     * 获取食品名称
     * @return 食品名称
     */
    String getName();

    /**
     * 获取包装
     * @return 装饰
     */
    Package getPackage();

    /**
     * 价格
     * @return 价格
     */
    int cost();
}
