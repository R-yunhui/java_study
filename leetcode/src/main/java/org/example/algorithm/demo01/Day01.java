package org.example.algorithm.demo01;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-04 20:58
 * @Describe: 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @Modify:
 */
public class Day01 {

    public static void main(String[] args) {

    }

    public static int removeElement(int[] nums, int val) {
        // 双指针移除
        int n = nums.length;
        int i = 0;
        // 防止出现数组下标越界
        while (n > i) {
            if (nums[i] == val) {
                // 将第一个数据和最后一个数据交换 并移除最后一个数据 再次进行遍历
                nums[i] = nums[n - 1];
                n--;
            } else {
                // 否则继续向后遍历
                i++;
            }
        }
        return i;
    }
}
