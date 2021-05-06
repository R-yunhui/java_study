/*
 * @projectName raladmin
 * @package com.ral.admin.sort
 * @className com.ral.admin.sort.QuickSort
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.sort;

import java.util.Arrays;

/**
 * QuickSort
 * @Description 快速排序 java实现
 * @author renyunhui
 * @date 2021/4/30 9:23
 * @version 1.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        quickSort(arr, 0, arr.length - 1);
        System.err.println(Arrays.toString(arr));
    }

    /**
     * 快速排序
     * @param arr 排序的数组
     * @param low 数组的左边界
     * @param high 数组的右边界
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int i = low;
        int j = high;
        // tag就是基准位
        int tag = arr[low];

        while (i < j) {
            // 从尾部依次往左递减
            while (tag <= arr[j] && i < j) {
                j--;
            }
            // 从头部依次往右递增
            while (tag >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = tag;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }
}
