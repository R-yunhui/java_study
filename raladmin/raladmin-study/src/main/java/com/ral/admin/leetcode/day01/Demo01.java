/*
 * @projectName raladmin
 * @package org.example.algorithm.demo03
 * @className org.example.algorithm.demo03.Day07
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.leetcode.day01;

/**
 * Day07
 * @Description: 2021-03-26 每日一题  【83】删除排序链表中的重复元素
 * @author renyunhui
 * @date 2021/3/26 13:55
 * @version 1.0
 */
public class Demo01 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))))));
        nodeToString(node);

        System.err.println();

        ListNode newNode = deleteDuplicatesNew(node);
        nodeToString(newNode);
    }

    public static void nodeToString(ListNode node) {
        if (null != node) {
            System.err.print(node.val + " ");
            nodeToString(node.next);
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicatesNew(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        while (null != head.next && head.next.val == head.val) {
            // 重复则修改当前节点为当前节点的下一节点
            head = head.next;
        }
        head.next = deleteDuplicates(head.next);
        return head;
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
