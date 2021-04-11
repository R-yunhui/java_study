package com.ral.admin.leetcode.day07;

/**
 * @Author: RenYunHui
 * @Date: 2021-04-02 21:38
 * @Describe:
 * @Modify:
 */
public class Demo01 {

    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        System.err.println(demo01.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}
