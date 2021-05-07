package com.ral.admin.practice;

/**
 * @Author: RenYunHui
 * @Date: 2021-05-07 9:20
 * @Describe: leetcode 每日一题 1486. 数组异或操作
 * @Modify:
 */
public class Day07 {

    public static void main(String[] args) {
        System.err.println(new Day07().xorOperation(1, 7));
    }

    public int xorOperation(int n, int start) {
        // nums[i] = start + 2*i
        // n == nums.length
        if (n >= 2) {
            int end = start + 2;
            int temp = start ^ end;
            while (n != 2) {
                n--;
                end = end + 2;
                temp = temp ^ end;
            }
            return temp;
        }
        return start;
    }
}
