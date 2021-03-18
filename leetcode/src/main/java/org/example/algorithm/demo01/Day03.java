package org.example.algorithm.demo01;

import java.util.Arrays;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-18 20:50
 * @Describe: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @Modify:
 */
public class Day03 {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 12};
        moveZeroesThree(arr);
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            OUT:
            // 找到0
            if (nums[i] == 0) {
                // 找到第一个不为0的数 交换位置
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break OUT;
                    }
                }
            }
        }
        System.err.println(Arrays.toString(nums));
    }

    public static void moveZeroesTwo(int[] nums) {
        int j = 0;
        // 将所有不为0的往前放
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        // 后续则全为0
        for (int a = j; a < nums.length; a++) {
            nums[a] = 0;
        }
        System.err.println(Arrays.toString(nums));
    }

    public static void moveZeroesThree(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
        System.err.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
