/*
 * @projectName raladmin
 * @package com.ral.admin.leetcode.Day01
 * @className com.ral.admin.leetcode.Day01.Demo03
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.leetcode.day01;

/**
 * Demo03
 * @Description: 2021-03-26 中等题目练习 【2】两数相加
 * @author renyunhui
 * @date 2021/3/26 14:46
 * @version 1.0
 */
public class Demo03 {
    static int num = 0;
    static ListNode node = new ListNode();

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        addTwoNumbers(l1, l2);
        nodeToString(node);
    }


    public static void nodeToString(ListNode node) {
        if (null != node) {
            System.err.print(node.val + " ");
            nodeToString(node.next);
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = node;
        while (l1 != null && l2 != null) {
            // 如果前两个节点的值相加 > 10  则当前两个几点的值需 + num
            listNode.val = getValue(l1, l2);
            // 判断两个节点的值相加是否大于10
            l1 = l1.next;
            l2 = l2.next;
            node.next = addTwoNumbers(l1, l2);
        }
        return node;
    }

    public static int getValue(ListNode l1, ListNode l2) {
        int temp = 0 == num ? (l1.val + l2.val) % 10 : (l1.val + l2.val + num) % 10;
        num = (l1.val + l2.val) / 10;
        return temp;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
