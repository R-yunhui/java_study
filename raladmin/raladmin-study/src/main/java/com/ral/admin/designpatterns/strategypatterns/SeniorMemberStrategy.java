package com.ral.admin.designpatterns.strategypatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-28 13:17
 * @Describe: 高级会员策略实现类
 * @Modify:
 */
public class SeniorMemberStrategy implements Strategy {

    @Override
    public double calculatePrice(double price) {
        return price * 0.7;
    }
}
