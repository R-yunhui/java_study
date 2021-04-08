/*
 * @projectName raladmin
 * @package com.ral.admin.leetcode.day11
 * @className com.ral.admin.leetcode.day11.Demo01
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.leetcode.day11;

/**
 * Demo01
 * @Description: leetcode 每日一题 【153】寻找旋转排序数组中的最小值
 * @author renyunhui
 * @date 2021/4/8 8:48
 * @version 1.0
 */
public class Demo01 {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }


}
