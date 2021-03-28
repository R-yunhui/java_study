package com.ral.admin.designpatterns.statepatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-28 13:45
 * @Describe: 不可以抽奖的状态实现类
 * @Modify:
 */
public class NoLotteryState implements ActiveState {

    private LotteryActivity lotteryActivity;

    public NoLotteryState(LotteryActivity lotteryActivity) {
        this.lotteryActivity = lotteryActivity;
    }

    @Override
    public void deductPoints() {
        System.out.println("扣除50积分成功,请准备开始抽奖!!");
        // 修改为允许抽奖的状态
        lotteryActivity.setActiveState(lotteryActivity.getLotteryState());
    }

    @Override
    public void issuePrizes() {
        System.out.println("未开始抽奖,暂不允许发放奖品!!");
    }

    @Override
    public boolean isLottery() {
        System.out.println("积分暂未扣除,暂不允许抽奖!!");
        return false;
    }
}
