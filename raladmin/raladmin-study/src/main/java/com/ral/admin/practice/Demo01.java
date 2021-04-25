package com.ral.admin.practice;

import java.util.Arrays;

/**
 * @Author: RenYunHui
 * @Date: 2021-04-18 18:31
 * @Describe: leetcode  【26】. 删除有序数组中的重复项
 * @Modify:
 */
public class Demo01 {

    public static void main(String[] args) {
        System.err.println(new Demo01().removeDuplicates(new int[]{0, 1, 1, 1, 2, 2, 3, 4, 5}));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        // [0, slow] 是不重复的区间
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            // [0, 1, 1, 1, 2, 2, 3, 4, 5]
            // 不相等 则替换位置  相等的值都是连续的
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        // fast 指向的是新数组中末尾的元素，即新数组最后的索引
        // 而索引从0开始，题目要求返回新数组的长度，因此返回slow+1
        return slow + 1;
    }
}
