/*
 * @projectName raladmin
 * @package com.ral.admin.practice
 * @className com.ral.admin.practice.Day02
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.tree.TreeNode;

import com.google.common.collect.Lists;

/**
 * Day02
 * @Description 2021-04-27 leetcode 每日一题 938. 二叉搜索树的范围和
 * @author renyunhui
 * @date 2021/4/27 17:17
 * @version 1.0
 */
public class Day02 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode rightThree = new TreeNode(18);
        TreeNode leftTwo = new TreeNode(3);
        TreeNode rightTwo = new TreeNode(7);
        TreeNode leftOne = new TreeNode(5, leftTwo, rightTwo);
        TreeNode rightOne = new TreeNode(15, null, rightThree);
        TreeNode root = new TreeNode(10, leftOne, rightOne);
        Day02 day02 = new Day02();
        System.err.println(day02.rangeSumBST(root, 7, 15));
        System.err.println(day02.rangeSumBSTDeep(root, 7, 15));
    }


    public int rangeSumBST(TreeNode root, int low, int high) {
        // 二叉搜索树 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树
        // 广度优先遍历
        LinkedList<TreeNode> queue = new LinkedList<>();
        int count = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (null == temp) {
                continue;
            }

            if (temp.val < low) {
                queue.add(temp.right);
            } else if (temp.val > high){
                queue.add(temp.left);
            } else {
                count += temp.val;
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        return count;
    }

    public int rangeSumBSTDeep(TreeNode root, int low, int high) {
        // 深度优先遍历 递归
        if (null == root) {
            return 0;
        }

        if (root.val > high) {
            // 递归遍历右子树
            return rangeSumBSTDeep(root.left, low, high);
        }

        if (root.val < low) {
            // 递归遍历左子树
            return rangeSumBSTDeep(root.right, low, high);
        }

        return root.val + rangeSumBSTDeep(root.left, low, high) + rangeSumBSTDeep(root.right, low, high);
    }
}
