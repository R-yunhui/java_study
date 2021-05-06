/*
 * @projectName raladmin
 * @package com.ral.admin.practice
 * @className com.ral.admin.practice.Day03
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.practice;

/**
 * Day03
 * @Description 2021-04-28 leetcode 每日一题 633. 平方数之和
 * @author renyunhui
 * @date 2021/4/28 9:02
 * @version 1.0
 */
public class Day03 {

    public static void main(String[] args) {
        System.err.println(new Day03().judgeSquareSum(4));
    }

    public boolean judgeSquareSum(int c) {
        // 双指针
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int temp = left * left + right * right;
            // 依次遍历
            if (temp < c) {
                left++;
            } else if (temp > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }
}
