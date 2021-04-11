package com.ral.admin.leetcode.day08;

import java.util.Arrays;

/**
 * @Author: RenYunHui
 * @Date: 2021-04-05 14:40
 * @Describe: 2021-04-05 leetcode 每日一题 【88】合并两个有序数组
 * @Modify:
 */
public class Demo01 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 6, 0, 0};
        int[] nums2 = new int[]{5, 7};
        Demo01 demo01 = new Demo01();
        demo01.merge(nums1, 4, nums2, 2);
        demo01.mergeTwo(nums1, 4, nums2, 2);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
        System.err.println(Arrays.toString(nums1));
    }

    public void mergeTwo(int[] nums1, int m, int[] nums2, int n) {
        // nums1数组的最后以为  nums1 从后遍历 值都为0
        int p1 = m - 1;
        // nums2数组的最后一位
        int p2 = n - 1;
        // 合并后数组的最后一位
        int tail = m + n - 1;
        while (p2 >= 0) {
            if (p1 < 0 || nums1[p1] <= nums2[p2]) {
                nums1[tail--] = nums2[p2--];
            } else {
                nums1[tail--] = nums1[p1--];
            }
        }
        System.err.println(Arrays.toString(nums1));
    }
}
