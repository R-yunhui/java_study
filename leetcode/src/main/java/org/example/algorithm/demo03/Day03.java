package org.example.algorithm.demo03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-11 20:17
 * @Describe:
 * @Modify:
 */
public class Day03 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 1, 1};
        System.err.println(containsNearbyDuplicateBySet(arr, 1));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (i + j < nums.length && nums[i] == nums[i + j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicateBySet(int[] nums, int k) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);

            // 超出查询范围 移除最旧 i - k 的元素
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicateByMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(k);
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            map.put(nums[i], i);
            if (index != null && (i - index <= k)) {
                return true;
            }
        }
        return false;
    }
}
