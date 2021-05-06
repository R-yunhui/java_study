package com.ral.admin.designpatterns.statepatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-28 13:32
 * @Describe:
 * @Modify:
 */
public class Test {

    public static void main(String[] args) {
        LotteryActivity lotteryActivity = new LotteryActivity(5);
        // 抽奖50次
        for (int i = 1; i <= 10; i++) {
            System.out.println("开始第" + i + "次抽奖");
            lotteryActivity.deductPoints();

            lotteryActivity.isLottery();

            System.out.println("第" + i + "次抽奖结束");
        }
    }
}
