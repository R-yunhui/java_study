package com.ral.admin.leetcode.day12;

import java.util.Arrays;

/**
 * @Author: RenYunHui
 * @Date: 2021-04-12 21:33
 * @Describe: 2021-04-12 leetcode 每日一题 【179】
 * @Modify:
 */
public class Demo01 {

    public static void main(String[] args) {
        System.err.println(new Demo01().largestNumberTwo(new int[]{2, 10}));
    }

    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] + "";
        }

        // 降序排序
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if ("0".equals(arr[0])) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }

    public String largestNumberTwo(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        if (nums[0] == 0) {
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int a : nums) {
            stringBuilder.append(a);
        }
        return stringBuilder.toString();
    }


    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = nums[start];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            long x = 10;
            long y = 10;
            while (nums[i] >= x) {
                x *= 10;
            }
            while (pivot >= y) {
                y *= 10;
            }
            if (nums[i] * y + pivot > nums[i] + pivot * x) {
                index += 1;
                swap(nums, index, i);
            }
        }
        swap(nums, index, start);
        quickSort(nums, start, index - 1);
        quickSort(nums, index + 1, end);
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
