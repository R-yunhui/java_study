package com.ral.admin.designpatterns.strategypatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-28 11:58
 * @Describe: 超市要做一个不同会员打折力度不同的三种策略，初级会员，中级会员，高级会员（三种不同的计算）。初级9折，中级8折，高级7折。画出对应的类图，完成相应的程序。
 * @Modify:
 */
public class Test {

    public static void main(String[] args) {
        double price = 175.85;
        Strategy strategy = new NormalMemberStrategy();
        StrategyContext context = new StrategyContext(strategy);
        price = context.calculatePrice(price);
        System.out.println(price);
    }
}
