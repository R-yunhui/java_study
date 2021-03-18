package org.example.algorithm.demo03;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-11 20:51
 * @Describe:
 * @Modify:
 */
public class Day04 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            // 当当前节点的值和其下一节点的值不同 递归
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            // 当当前节点的值和其下一节点的值相同 递归
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

    public ListNode deleteDuplicatesNew(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        ListNode cur = prev.next;
        while (cur != null) {
            int curRepeatNum = 0;
            ListNode difNode = cur;
            // 找到和cur指向的结点值不同的结点
            while (difNode != null && difNode.val == cur.val) {
                curRepeatNum++;
                difNode = difNode.next;
            }

            // 如果curRepeatNum的值大于1，则表示cur指向的结点重复出现了
            if (curRepeatNum > 1) {
                prev.next = difNode;
            }else {
                // cur指向的结点没有重复出现，则将变量prev指向cur所指向的结点
                prev = cur;
            }
            cur = difNode;
        }

        return dummyHead.next;
    }
}

class ListNode {
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
