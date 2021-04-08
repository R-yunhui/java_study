package com.ral.admin.designpatterns.decoratorpatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-29 21:29
 * @Describe:
 * @Modify:
 */
public class Test {

    public static void main(String[] args) {
        Beverage milkShake = new MilkShake();
        Beverage milkTea = new MilkTea();
        Beverage fruitTea = new FruitTea();
        Pearl pearl = new Pearl(milkShake);
        Coconut coconut = new Coconut(milkShake);
        RedBeans redBeans = new RedBeans(milkTea);
        IceCream iceCream = new IceCream(fruitTea);
        System.out.println(pearl.getDescription() + "价格：" + pearl.cost() + "元");
        System.out.println(coconut.getDescription() + "价格：" + coconut.cost() + "元");
        System.out.println(redBeans.getDescription() + "价格：" + redBeans.cost() + "元");
        System.out.println(iceCream.getDescription() + "价格：" + iceCream.cost() + "元");

    }
}
