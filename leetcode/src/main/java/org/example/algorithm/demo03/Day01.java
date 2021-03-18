package org.example.algorithm.demo03;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-07 16:41
 * @Describe:
 * @Modify:
 */
public class Day01 {

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.err.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        // 求出每一段的最大值 作比较 得出最大和的连续子数组 f(i) = Max{f(i) + nums[i], nums[i]}  f(i)为从[0, i) 的值之和 => max = Max{f(i)}
        int count = 0;
        int max = nums[0];
        for (int num : nums) {
            count = Math.max(num + count, num);
            max = Math.max(count, max);
        }
        return max;
    }
}
