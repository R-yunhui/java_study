/*
 * @projectName raladmin
 * @package com.ral.admin.recursion
 * @className com.ral.admin.recursion.Demo02
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Demo02
 * @Description 青蛙跳楼梯 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * @author renyunhui
 * @date 2021/4/26 10:49
 * @version 1.0
 */
public class Demo02 {

    public static void main(String[] args) {
        System.err.println(new Demo02().numWays(3));
        System.err.println(new Demo02().numWaysTwo(3));
    }

    /** 使用哈希map，充当备忘录的作用 */
    Map<Integer, Integer> tempMap = new HashMap(16);

    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }

        if (n <= 2) {
            return n;
        }

        //先判断有没计算过，即看看备忘录有没有
        if (tempMap.containsKey(n)) {
            //备忘录有，即计算过，直接返回
        } else {
            // 临时map不存在，即没有计算过，执行递归计算,并且把结果保存到备忘录map中，对1000000007取余
            tempMap.put(n, (numWays(n - 1) + numWays(n - 2)) % 1000000007);
        }
        return tempMap.get(n);
    }

    public int numWaysTwo(int n) {
        // 动态规划的方式解决  f(n) = f(n-1) + f(n-2)  sum = a + b
        int sum;
        int a = 1;
        int b = 1;
        for (int i = 0; i < n; i++) {
            // 相互继承  b -> a   a -> sum
            sum = (a + b) % 1000000007;
            b = a;
            a = sum;
        }
        return b;
    }
}
