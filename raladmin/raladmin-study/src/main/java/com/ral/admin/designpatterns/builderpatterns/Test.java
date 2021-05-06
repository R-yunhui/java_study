/*
 * @projectName raladmin
 * @package com.ral.admin.designpatterns.builderpatterns
 * @className com.ral.admin.designpatterns.builderpatterns.Test
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.designpatterns.builderpatterns;

/**
 * Test
 * @Description 建造者模式测试类
 * @author renyunhui
 * @date 2021/3/31 8:59
 * @version 1.0
 */
public class Test {

    public static void main(String[] args) {
        SetMealBuilder setMealBuilder = new SetMealBuilder();
        setMealBuilder.orderOne().showFood();
        System.out.println("套餐一总价：￥" + setMealBuilder.orderOne().getCost() + "\n");

        setMealBuilder.orderTwo().showFood();
        System.out.println("\n套餐二总价：￥" + setMealBuilder.orderTwo().getCost());

        setMealBuilder.orderThree().showFood();
        System.out.println("套餐三总价：￥" + setMealBuilder.orderThree().getCost());

    }
}
