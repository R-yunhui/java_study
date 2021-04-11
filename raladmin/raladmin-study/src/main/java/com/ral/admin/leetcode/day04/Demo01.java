package com.ral.admin.leetcode.day04;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-30 21:34
 * @Describe: 2021-03-30 leetcode 每日一题 【74】搜素二维矩阵
 * @Modify:
 */
public class Demo01 {

    public static void main(String[] args) {
        int[][] arr = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        Demo01 demo01 = new Demo01();
        System.err.println(demo01.searchMatrixThree(arr, 23));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // 由于每一列都是升序的 二分查找第一列找到对应最后一个大于目标值的值所在的行 在对此行进行二分查找判断该值是否存在
        int rowIndex = binarySearchFirstColumn(matrix, target);
        if (rowIndex < 0) {
            return false;
        }
        return binarySearchRow(matrix[rowIndex], target);
    }

    public int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = -1, high = matrix.length - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean binarySearchRow(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    // ------------------------
    public  boolean searchMatrixTwo(int[][] matrix, int target) {
        // 将二维数组 转为一维数组 在进行二分查找（都是升序排列）
        for (int[] ints : matrix) {
            // 判断是否在此行中
            if (target < ints[0] || target > ints[ints.length - 1]) {
                continue;
            }
            // 二分查找
            return binarySearch(ints, target);
        }
        return false;
    }

    public  boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2 + start;
            if (target < arr[middle]) {
                end = middle - 1;
            } else if (target > arr[middle]) {
                start = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    // --------------------
    public boolean searchMatrixThree(int[][] matrix, int target) {
        // 将二维数组转换为一维数组进行二分查找
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
