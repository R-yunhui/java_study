/*
 * @projectName raladmin
 * @package com.ral.admin.designpatterns.builderpatterns
 * @className com.ral.admin.designpatterns.builderpatterns.FoodBuilder
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.designpatterns.builderpatterns;

/**
 * FoodBuilder
 * @Description 食品组装
 * @author renyunhui
 * @date 2021/3/31 12:25
 * @version 1.0
 */
public class SetMealBuilder {

    /**
     * 组装套餐一
     * @return 套餐一
     */
    public SetMeal orderOne() {
        SetMeal setMeal = new SetMeal();
        setMeal.addItem(new ChickHamburger());
        setMeal.addItem(new Cola());
        return setMeal;
    }

    public SetMeal orderTwo() {
        SetMeal setMeal = new SetMeal();
        setMeal.addItem(new BeefHamburger());
        setMeal.addItem(new OrangeJuice());
        return setMeal;
    }

    public SetMeal orderThree() {
        SetMeal setMeal = new SetMeal();
        setMeal.addItem(new ChickHamburger());
        setMeal.addItem(new Sprite());
        return setMeal;
    }
}
