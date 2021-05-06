/*
 * @projectName raladmin
 * @package com.ral.admin.recursion
 * @className com.ral.admin.recursion.Demo03
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Demo03
 * @Description 斐波那契数列
 * @author renyunhui
 * @date 2021/4/26 11:45
 * @version 1.0
 */
public class Demo03 {


    public static void main(String[] args) {
        System.err.println(new Demo03().fib(3));
        System.err.println(new Demo03().fibTwo(3));
    }

    Map<Integer, Integer> map = new HashMap<>(16);

    public int fib(int n) {
        // 递归解决 f(0) = 0  f(1) = 1
        if (n == 0) {
            return 0;
        }

        if (n <= 2) {
            return 1;
        }

        // 包含则直接返回
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            // 不包含 则将此次计算的结果放入map
            map.put(n, (fib(n - 1) + fib(n - 2)) % 1000000007);
        }
        return map.get(n);
    }

    public int fibTwo(int n) {
        // 动态规划解决 f(n) = f(n-1) + f(n-2)
        int sum;
        int a = 1;
        int b = 0;
        for (int i = 0; i < n; i++) {
            // 相互继承  b -> a   a -> sum
            sum = (a + b) % 1000000007;
            b = a;
            a = sum;
        }
        return b;
    }

}
