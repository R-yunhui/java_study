/*
 * @projectName raladmin
 * @package org.example.algorithm.demo03
 * @className org.example.algorithm.demo03.Day06
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package org.example.algorithm.demo03;

import java.util.Arrays;

/**
 * Day06
 * @Description 给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 说明：
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下：
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *   print(nums[i]);
 * }
 *
 * @author renyunhui
 * @date 2021/3/25 14:40
 * @version 1.0
 */
public class Day06 {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.err.println(removeDuplicatesNew(arr));
    }

    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            // 相等 且重复次数小于2
            if (nums[slow] == nums[i] && count < 2) {
                count++;
                slow++;
                nums[slow] = nums[i];
            }

            // 不相等的情况 重置计数器
            if (nums[slow] != nums[i]) {
                slow++;
                count = 1;
                nums[slow] = nums[i];
            }
        }
        System.err.println(Arrays.toString(nums));
        return slow + 1;
    }

    /**
     * 我们使用了两个指针，i 是遍历指针，指向当前遍历的元素；j 指向下一个要覆盖元素的位置。
     * 同样，我们用 count 记录当前数字出现的次数。count 的最小计数始终为 1。
     * 我们从索引 1 开始一次处理一个数组元素。
     * 若当前元素与前一个元素相同，即 nums[i]==nums[i-1]，则 count++。若 count > 2，则说明遇到了多余的重复项。在这种情况下，我们只向前移动 i，而 j 不动。
     * 若 count <=2，则我们将 i 所指向的元素移动到 j 位置，并同时增加 i 和 j。
     * 若当前元素与前一个元素不相同，即 nums[i] != nums[i - 1]，说明遇到了新元素，则我们更新 count = 1，并且将该元素移动到 j 位置，并同时增加 i 和 j。
     * 当数组遍历完成，则返回 j。
     * @param nums 数组
     * @return 符合的个数
     */
    public static int removeDuplicatesNew(int[] nums) {
        // 0 - j 是符合条件的数据区域
        int count = 1;
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        System.err.println(Arrays.toString(nums));
        return j;
    }
}
