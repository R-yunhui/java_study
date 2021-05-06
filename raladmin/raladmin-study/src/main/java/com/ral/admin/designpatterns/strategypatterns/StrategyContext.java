package com.ral.admin.designpatterns.strategypatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-28 13:18
 * @Describe:
 * @Modify:
 */
public class StrategyContext {

    private Strategy strategy;

    /**
     *
     * @param strategy 具体策略的实现
     */
    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public double calculatePrice(double price) {
        return strategy.calculatePrice(price);
    }
}
