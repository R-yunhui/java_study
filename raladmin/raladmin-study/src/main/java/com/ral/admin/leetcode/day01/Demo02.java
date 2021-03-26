/*
 * @projectName raladmin
 * @package com.ral.admin.leetcode.Day01
 * @className com.ral.admin.leetcode.Day01.Demo02
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.leetcode.day01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Demo02
 * @Description: 2021-03-26 简单题目练习 【1】两数之和
 * @author renyunhui
 * @date 2021/3/26 14:35
 * @version 1.0
 */
public class Demo02 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        System.err.println(Arrays.toString(twoSum(arr, 13)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (null != map.get(nums[i])) {
                // 找到差值 给数组赋值
                return new int[]{map.get(nums[i]), i};
            }
            // 将差值和当前的下标放入map中
            map.put(target - nums[i], i);
        }
        return new int[2];
    }
}
