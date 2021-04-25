package com.ral.admin.leetcode.day13;

/**
 * @Author: RenYunHui
 * @Date: 2021-04-18 11:03
 * @Describe: 斐波那契数列
 * @Modify:
 */
public class Demo01 {

    public static void main(String[] args) {
        System.err.println(new Demo01().fib(3));
    }

    public int fib(int n) {
        int num1 = 0;
        int num2 = 1;
        int sum;
        for (int i = 0; i < n; i++) {
            sum = (num1 + num2) % 1000000007;
            num1 = num2;
            num2 = sum;
        }
        return num1;
    }
}
