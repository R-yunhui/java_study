/*
 * @projectName raladmin
 * @package com.ral.admin.designpatterns.builderpatterns
 * @className com.ral.admin.designpatterns.builderpatterns.SetMeal
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.designpatterns.builderpatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SetMeal
 * @Description 食品套餐
 * @author renyunhui
 * @date 2021/3/31 12:26
 * @version 1.0
 */
public class SetMeal {

    private List<Food> foods = new ArrayList<>();

    public void addItem(Food food) {
        foods.add(food);
    }

    /**
     * 获取总消费
     * @return 总消费
     */
    public int getCost() {
        return foods.stream().mapToInt(Food::cost).sum();
    }

    public void showFood() {
        foods.forEach(food ->
                System.out.print("餐品：" + food.getName() + "\n包装：" + food.getPackage().getPackType() + "\n价格：￥" + food.cost() + "\n")
        );
    }
}
