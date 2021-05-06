package com.ral.admin.practice;

import java.util.Arrays;

/**
 * @Author: RenYunHui
 * @Date: 2021-05-06 11:14
 * @Describe: leetcode 每日一题
 * @Modify:
 */
public class Day06 {

    public static void main(String[] args) {
        System.err.println(Arrays.toString(new Day06().decode(new int[]{1, 2, 3}, 1)));
    }

    public int[] decode(int[] encoded, int first) {
        // decode[] decode[i] ^ decode[i+1] = encode[i];
        // 0 ^ 1 = 1  1 ^ 0 = 1  0 ^ 0 = 0  1 ^ 1 = 0
        int length = encoded.length + 1;
        int[] decode = new int[length];
        decode[0] = first;
        for (int i = 1; i < decode.length; i++) {
            // 异或满足交换律 任何数和0异或是其本身
            decode[i] = decode[i - 1] ^ encoded[i - 1];
        }
        return decode;
    }
}

