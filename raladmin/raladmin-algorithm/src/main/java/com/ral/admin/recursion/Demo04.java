/*
 * @projectName raladmin
 * @package com.ral.admin.recursion
 * @className com.ral.admin.recursion.Demo04
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.recursion;

import java.util.Arrays;

/**
 * Demo04
 * @Description 二分 167. 两数之和 II - 输入有序数组
 * @author renyunhui
 * @date 2021/4/28 18:14
 * @version 1.0
 */
public class Demo04 {

    public static void main(String[] args) {
        System.err.println(Arrays.toString(new Demo04().twoSum(new int[]{-1, 0}, -1)));
    }

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1;
            int high = numbers.length - 1;
            while (low <= high) {
                int mid = ((high - low) >> 1) + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSumTwo(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{-1, -1};
    }
}
