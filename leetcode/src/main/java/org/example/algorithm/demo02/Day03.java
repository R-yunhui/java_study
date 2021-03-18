package org.example.algorithm.demo02;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-04 21:43
 * @Describe: 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为 1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 * @Modify:
 */
public class Day03 {

    public static void main(String[] args) {
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        // 判断当前数是否已经出现过 或者当前数不为1
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            // 获取计算后的下一个数
            n = getNextNum(n);
        }
        return n == 1;
    }

    private int getNextNum(int n) {
        // 通过计算得到的下一个数
        int totalNum = 0;
        while (n > 0) {
            // 计算个位数
            int d = n % 10;
            // 缩小一位
            n = n / 10;
            totalNum += d * d;
        }
        return totalNum;
    }
}
