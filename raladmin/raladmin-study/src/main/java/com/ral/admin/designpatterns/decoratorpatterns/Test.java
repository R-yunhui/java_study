package com.ral.admin.designpatterns.decoratorpatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-29 21:29
 * @Describe:
 * @Modify:
 */
public class Test {

    public static void main(String[] args) {
        Beverage coffee = new Coffee();
        Coconut coconut = new Coconut(coffee);
        System.out.println(coconut.getDescription() + "价格：" + coconut.cost() + "元");

        Beverage milkTea = new MilkTea();
        RedBeans redBeans = new RedBeans(milkTea);
        System.out.println(redBeans.getDescription() + "价格：" + redBeans.cost() + "元");
    }
}
