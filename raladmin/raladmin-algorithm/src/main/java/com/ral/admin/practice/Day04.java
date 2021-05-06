/*
 * @projectName raladmin
 * @package com.ral.admin.practice
 * @className com.ral.admin.practice.Day04
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.practice;

/**
 * Day04
 * @Description 2021-04-29 leetcode 403. 青蛙过河
 * stones = [0,1,3,5,6,8,12,17]
 * 一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
 *
 * 给你石子的位置列表 stones（用单元格序号 升序 表示），请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
 *
 * 开始时，青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
 *
 * 如果青蛙上一步跳跃了k个单位，那么它接下来的跳跃距离只能选择为k - 1、k或k + 1 个单位。另请注意，青蛙只能向前方（终点的方向）跳跃。
 *
 * @author renyunhui
 * @date 2021/4/29 11:02
 * @version 1.0
 */
public class Day04 {

    public static void main(String[] args) {
        System.err.println(new Day04().canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
    }

    public boolean canCross(int[] stones) {
        // 动态规划状态转移方程：dp[i][k] = dp[j][k-1] || dp[j][k] || dp[j][k+1]
        // i：现在石头的编号 k：上一次跳跃的距离 dp[i][k]：本次能否到达的状态  j：上一次石头的编号
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        // 第一次已经在石头上
        dp[0][0] = true;

        // 结论：
        // 1.青蛙每次跳跃所在的石头的编号至少+1 相对于上次的跳跃距离至多+1
        // 2.跳跃m次后 i >= m  上一次跳跃的距离 k <= m  => k <= i
        // 3.判断上一次的石头编号和本次的石头编号之间的差一定小于本次石头的编号
        for (int i = 1; i < n; i++) {
            // 结论3：
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }

        // i：现在所处的石头编号  j：上一次所在石头的编号
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // 本次需要跳跃的距离
                int k = stones[i] - stones[j];
                // 结论1,2
                // 在j号石头的上一次跳跃的距离至多为j-1 则本次跳跃的最大距离为j
                if (k > j + 1) {
                    break;
                }
                // 动态转移方程
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                // 如果动态转移方程在最有一个石头处成立 则返回true
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }
}
