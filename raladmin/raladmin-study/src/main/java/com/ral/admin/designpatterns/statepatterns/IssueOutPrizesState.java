package com.ral.admin.designpatterns.statepatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-28 13:45
 * @Describe: 奖品领完的状态实现类
 * @Modify:
 */
public class IssueOutPrizesState implements ActiveState {

    private LotteryActivity lotteryActivity;

    public IssueOutPrizesState(LotteryActivity lotteryActivity) {
        this.lotteryActivity = lotteryActivity;
    }

    @Override
    public void deductPoints() {
        System.out.println("奖品已发完,请下次在参与此活动!!");
    }

    @Override
    public void issuePrizes() {
        System.out.println("奖品已发完,请下次在参与此活动!!");
    }

    @Override
    public boolean isLottery() {
        System.out.println("奖品已发完,请下次在参与此活动!!");
        return false;
    }
}
