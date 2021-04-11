package com.ral.admin.leetcode.day10;

/**
 * @Author: RenYunHui
 * @Date: 2021-04-07 21:28
 * @Describe:
 * @Modify:
 */
public class Demo01 {

    public static void main(String[] args) {

    }

    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }

        if (n == 1) {
            return nums[0] == target;
        }

        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // 如果左 中 右 全部相等 则缩小区间范围  反之依次比较 左 - 中  中 - 右两个区间
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                ++l;
                --r;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
