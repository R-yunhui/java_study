package com.ral.admin.leetcode.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-31 21:06
 * @Describe: 2021-03-31 leetcode 每日一题 【90】子集II
 * @Modify:
 */
public class Demo01 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 7, 3, 9};
        Demo01 demo01 = new Demo01();
        System.err.println(demo01.subsetsWithDup(nums));
    }

    private List<List<Integer>> ans;
    private List<Integer> path;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        // 首先排序，让相同的两个元素排到一起去，便于去重
        Arrays.sort(nums);
        int n = nums.length;
        // 使用 visited 数组来记录哪一个元素在当前路径中被使用了
        boolean[] visited = new boolean[n];
        // 开始回溯
        backtrace(nums, 0, visited, n);
        return ans;
    }

    private void backtrace(int[] nums, int start, boolean[] visited, int n) {
        // 首先加入当前路径
        ans.add(new ArrayList<>(path));
        // 从 start 开始遍历每一个元素，尝试加入路径中
        for (int i = start; i < n; ++i) {
            // 如果当前元素和前一个元素相同，而且前一个元素没有被访问，说明前一个相同的元素在当前层已经被用过了
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }
            // 记录下来，用过了当前的元素
            visited[i] = true;
            // 放到路径中
            path.add(nums[i]);
            // 向下一个递归
            backtrace(nums, i + 1, visited, n);
            // 回溯
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
