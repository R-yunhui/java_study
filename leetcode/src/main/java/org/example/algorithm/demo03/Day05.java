package org.example.algorithm.demo03;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-15 21:27
 * @Describe:
 * @Modify:
 */
public class Day05 {

    public static void main(String[] args) {
        System.err.println(addDigits(108));
    }

    public static int addDigits(int num) {
        while (num > 10) {
            num = cycleAdd(num);
        }
        return num == 10 ? 1 : num;
    }

    public static int cycleAdd(int num) {
        int count = 0;
        while (num > 10) {
            // 获取个位数
            count += num % 10;
            num = num / 10;
        }
        return count + num;
    }

    public int addDigitsTwo(int num) {
        while (num >= 10) {
            int next = 0;
            while (num != 0) {
                next = next + num % 10;
                num /= 10;
            }
            num = next;
        }
        return num;
    }

    public int addDigitsThree(int num) {
        return (num - 1) % 9 + 1;
    }
}
