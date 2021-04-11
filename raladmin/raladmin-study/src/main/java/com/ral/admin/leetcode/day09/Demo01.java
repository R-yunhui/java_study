package com.ral.admin.leetcode.day09;

/**
 * @Author: RenYunHui
 * @Date: 2021-04-06 20:57
 * @Describe: 2021-04-06 每日一题 【80】删除有序数组中的重复项II
 * @Modify:
 */
public class Demo01 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 2, 2, 3};
        System.err.println(new Demo01().removeDuplicates(arr));
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (nums.length <= 2) {
            return n;
        }
        int slow = 2;
        for (int fast = 2; fast < n; fast++) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
