/*
 * @projectName raladmin
 * @package com.ral.admin.practice
 * @className com.ral.admin.practice.Day01
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.practice;

import java.util.Arrays;

/**
 * Day01
 * @Description 2021-04-26 leetcode 每日一题 1011. 在 D 天内送达包裹的能力
 * @author renyunhui
 * @date 2021/4/26 13:55
 * @version 1.0
 */
public class Day01 {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 2, 4, 1, 4};
        System.err.println(new Day01().shipWithinDays(arr, 3));
    }

    public int shipWithinDays(int[] weights, int D) {
        // 借用二分的思想 左边界为货物重量的最大值 右边界为总重量
        int right = Arrays.stream(weights).sum();
        int left = Arrays.stream(weights).max().getAsInt();
        while (left < right) {
            // 假定船可承载的最小重量
            int mid = (left + right) >> 1;
            if (calculateDay(weights, mid, D)) {
                // 小于指定之间 减小承载量
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean calculateDay(int[] weights, int mid, int d) {
        int day = 1;
        int cur = 0;
        for (int weight : weights) {
            // 超出重量 则天数+1 当前承载货物归0
            if (cur + weight > mid) {
                ++day;
                cur = 0;
            }
            cur += weight;
        }
        return d >= day;
    }
}
