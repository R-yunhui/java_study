package com.ral.admin.designpatterns.statepatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-28 13:33
 * @Describe: 定义所有活动状态的接口
 * @Modify:
 */
public interface ActiveState {

    /**
     * 扣除积分
     */
    void deductPoints();

    /**
     * 发放奖品
     */
    void issuePrizes();

    /**
     * 是否抽中奖品
     * @return 是/否
     */
    boolean isLottery();
}
