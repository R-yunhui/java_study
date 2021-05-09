package com.ral.admin.practice;

/**
 * @Author: RenYunHui
 * @Date: 2021-05-09 18:12
 * @Describe: leetcode 每日一题  1482. 制作 m 束花所需的最少天数
 * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
 * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
 * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
 * @Modify:
 */
public class Day09 {

    public int minDays(int[] bloomDay, int m, int k) {
        // 当所需花大于数组中的花数量时，返回-1
        if (m > bloomDay.length / k) {
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = 0;
        for (int j : bloomDay) {
            low = Math.min(low, j);
            high = Math.max(high, j);
        }
        while (low < high) {
            int days = (high - low) / 2 + low;
            if (canMake(bloomDay, days, m, k)) {
                high = days;
            } else {
                low = days + 1;
            }
        }
        return low;
    }

    /**
     * 每次判断天数是否满足要求
     * @param bloomDay 花盛开所需时间的数组
     * @param m 所需花束数目
     * @param k 每个花束所需花的数目
     * @param days 当前天数
     * @return 是否符合要求
     */
    public boolean canMake(int[] bloomDay, int days, int m, int k) {
        // 计算其中的长度为 k 且最大元素不超过 days 的不重合的连续子数组的数量
        int bouquets = 0;
        // 花的数量
        int flowers = 0;
        int length = bloomDay.length;
        for (int i = 0; i < length && bouquets < m; i++) {
            if (bloomDay[i] <= days) {
                flowers++;
                // 存在最大元素不超过 days 的不重合的连续子数组
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                // 将花数置0 必须连续
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
