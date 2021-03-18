package org.example.algorithm.demo03;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-10 21:10
 * @Describe:
 * @Modify:
 */
public class Day02 {

    public static void main(String[] args) {
        String s = "a ";
        System.err.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        // 为先从后过滤掉空格找到单词尾部
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        if (end < 0) {
            return 0;
        }

        int start = end;
        // 再从尾部向前遍历，找到单词头部
        while(start >= 0 && s.charAt(start) != ' ') {
            start--;
        }

        // 相减，即为单词的长度
        return end - start;
    }
}
