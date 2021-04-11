package com.ral.admin.leetcode.day06;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: RenYunHui
 * @Date: 2021-04-01 21:31
 * @Describe:
 * @Modify:
 */
public class Demo01 {
    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        System.err.println(demo01.clumsy(4));
    }

    public int clumsy(int N) {
        if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else if (N  == 3) {
            return 6;
        } else if (N == 4) {
            return 7;
        }

        if (N % 4 == 0) {
            return N + 1;
        } else if (N % 4 <= 2) {
            return N + 2;
        } else {
            return N - 1;
        }
    }

    public int clumsyTwo(int N) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(N);
        N--;

        // 用于控制乘、除、加、减
        int index = 0;
        while (N > 0) {
            if (index % 4 == 0) {
                stack.push(stack.pop() * N);
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / N);
            } else if (index % 4 == 2) {
                stack.push(N);
            } else {
                stack.push(-N);
            }
            index++;
            N--;
        }

        // 把栈中所有的数字依次弹出求和
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
