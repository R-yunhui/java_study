package com.ral.admin.designpatterns.statepatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-28 13:45
 * @Describe: 发放奖品的状态实现类
 * @Modify:
 */
public class IssuePrizesState implements ActiveState {

    private LotteryActivity lotteryActivity;

    public IssuePrizesState(LotteryActivity lotteryActivity) {
        this.lotteryActivity = lotteryActivity;
    }

    @Override
    public void deductPoints() {
        System.out.println("积分已扣除,请不要重复扣除!!");
    }

    @Override
    public void issuePrizes() {
        if (lotteryActivity.getPrizeCount() > 0) {
            System.out.println("奖品已发放,请接收");
            // 奖品发放完毕,不允许再次抽奖
            lotteryActivity.setPrizeCount(lotteryActivity.getPrizeCount() - 1);
            lotteryActivity.setActiveState(lotteryActivity.getNoLotteryState());
        } else {
            System.out.println("奖品已发完,活动结束");
            // 修改完奖品发完的状态
            lotteryActivity.setActiveState(lotteryActivity.getIssueOutPrizesState());
            // 程序退出
            System.exit(0);
        }
    }

    @Override
    public boolean isLottery() {
        System.out.println("用户抽奖完毕,不允许重复抽奖!!");
        return false;
    }
}
