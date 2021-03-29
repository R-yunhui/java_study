package com.ral.admin.leetcode.day03;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-29 22:03
 * @Describe: leetcode每日一题  【190】.颠倒二进制
 * @Modify:
 */
public class Demo01 {

    public static void main(String[] args) {
        System.err.println(reverseBits(1));
    }

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // 每次左移 将最低位位移到最高位
            result <<= 1;

            // 用result的最低位 + 获取n的最低位
            result += n & 1;

            // 将n右移一位 更新n的最低位
            n >>>= 1;
        }
        return result;
    }
}
