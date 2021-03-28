package com.ral.admin.designpatterns.statepatterns;

import java.util.Random;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-28 13:45
 * @Describe: 可以抽奖的状态实现类
 * @Modify:
 */
public class LotteryState implements ActiveState {

    private LotteryActivity lotteryActivity;

    public LotteryState(LotteryActivity lotteryActivity) {
        this.lotteryActivity = lotteryActivity;
    }

    @Override
    public void deductPoints() {
        System.out.println("积分已扣除,请不要重复扣除!!");
    }

    @Override
    public void issuePrizes() {
        System.out.println("抱歉,你没有中奖!!");
    }

    @Override
    public boolean isLottery() {
        System.out.println("开始抽奖");
        // 抽奖命中率 10%
        int num = new Random().nextInt(10) + 1;
        if (num <= lotteryActivity.getProbability()) {
            System.err.println("恭喜中奖!!");
            lotteryActivity.setPrizeCount(lotteryActivity.getPrizeCount() - 1);
            System.err.println("当前奖品剩余:" + lotteryActivity.getPrizeCount());

            // 中奖 修改用户的活动状态为发放奖品
            lotteryActivity.setActiveState(lotteryActivity.getIssuePrizesState());
            return true;
        } else {
            System.out.println("抱歉,你没有中奖!!");
            // 没有中奖 修改用户的活动状态为未中奖
            lotteryActivity.setActiveState(lotteryActivity.getNoLotteryState());
            return false;
        }
    }
}
