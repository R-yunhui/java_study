/*
 * @projectName raladmin
 * @package com.ral.admin.practice
 * @className com.ral.admin.practice.Day05
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Day05
 * @Description 2021-04-30 leetcode 137. 只出现一次的数字 II
 * @author renyunhui
 * @date 2021/4/30 8:53
 * @version 1.0
 */
public class Day05 {

    public static void main(String[] args) {
        System.err.println(new Day05().singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
        System.err.println(new Day05().singleNumberTwo(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }

    public int singleNumber(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        int i = 0;
        // 防止数组下标越界
        while (i < nums.length - 1) {
            if (nums[i] != nums[i + 1]) {
                break;
            }
            i += 3;
        }
        return nums[i];
    }

    public int singleNumberTwo(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            // 将值放入map 相同key => 则value+1
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            // 只存在一个则退出循环
            if (entry.getValue() == 1) {
                result = num;
                break;
            }
        }
        return result;
    }
}
