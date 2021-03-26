package org.example.algorithm.demo01;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-04 21:22
 * @Describe: 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @Modify:
 */
public class Day02 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
        System.err.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {
        // 区间[0,slow]中的元素都是排序数组中只出现一次的元素
        int slow = 0;
        // 快指针fast的初始值为1，因为数组是排好序的
        // 因此数组中的第一个元素是一定存在于返回数组中的。
        for(int fast = 1; fast < nums.length; fast++) {
            // 当前考察的元素nums[fast]和nums[slow]不相等时
            // 说明nums[fast]是需要放入区间[0,slow]中的
            if (nums[fast] != nums[slow]) {
                // slow++是因为区间[0,slow]是左闭右闭的
                // 因此，在slow加1之后，在将nums[fast]的值赋予nums[slow]
                slow++;
                nums[slow] = nums[fast];
            }
        }
        // j指向的是新数组中末尾的元素，即新数组最后的索引
        // 而索引从0开始，题目要求返回新数组的长度，因此返回slow+1
        return slow + 1;
    }
}
