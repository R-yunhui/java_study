package com.ral.admin.designpatterns.statepatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-28 13:39
 * @Describe: 抽奖活动
 * @Modify:
 */
public class LotteryActivity {

    /**
     * 奖品数量
     */
    private int prizeCount;
    /**
     * 抽奖几率
     */
    private int probability;
    /**
     * 当前活动状态
     */
    private ActiveState activeState;
    /**
     * 四种活动状态
     */
    private IssuePrizesState issuePrizesState = new IssuePrizesState(this);
    private IssueOutPrizesState issueOutPrizesState = new IssueOutPrizesState(this);
    private LotteryState lotteryState = new LotteryState(this);
    private NoLotteryState noLotteryState = new NoLotteryState(this);

    public LotteryActivity(int prizeCount) {
        this.prizeCount = prizeCount;
        this.probability = 1;
        this.activeState = noLotteryState;
    }

    public LotteryActivity(int prizeCount, int probability) {
        this.prizeCount = prizeCount;
        this.probability = probability;
        this.activeState = noLotteryState;
    }

    public void deductPoints() {
        activeState.deductPoints();
    }

    public void isLottery() {
        // 抽奖完毕并中奖 发放奖品
        if (activeState.isLottery()) {
            activeState.issuePrizes();
        }
    }

    public int getPrizeCount() {
        return prizeCount;
    }

    public void setPrizeCount(int prizeCount) {
        this.prizeCount = prizeCount;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public ActiveState getActiveState() {
        return activeState;
    }

    public void setActiveState(ActiveState activeState) {
        this.activeState = activeState;
    }

    public IssuePrizesState getIssuePrizesState() {
        return issuePrizesState;
    }

    public void setIssuePrizesState(IssuePrizesState issuePrizesState) {
        this.issuePrizesState = issuePrizesState;
    }

    public IssueOutPrizesState getIssueOutPrizesState() {
        return issueOutPrizesState;
    }

    public void setIssueOutPrizesState(IssueOutPrizesState issueOutPrizesState) {
        this.issueOutPrizesState = issueOutPrizesState;
    }

    public LotteryState getLotteryState() {
        return lotteryState;
    }

    public void setLotteryState(LotteryState lotteryState) {
        this.lotteryState = lotteryState;
    }

    public NoLotteryState getNoLotteryState() {
        return noLotteryState;
    }

    public void setNoLotteryState(NoLotteryState noLotteryState) {
        this.noLotteryState = noLotteryState;
    }
}
