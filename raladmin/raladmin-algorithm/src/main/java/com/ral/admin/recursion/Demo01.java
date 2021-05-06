/*
 * @projectName raladmin
 * @package com.ral.admin.recursion
 * @className com.ral.admin.recursion.Demo01
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.recursion;


import java.util.LinkedList;

/**
 * Demo01
 * @Description 递归练习一  翻转二叉树
 * @author renyunhui
 * @date 2021/4/26 10:08
 * @version 1.0
 */
public class Demo01 {

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        // 深度优先遍历
        // 翻转二叉树的递归终止条件 当前节点为叶子节点或者为null
        boolean isSuspend = null == root || (null == root.right && null == root.left);
        if (isSuspend) {
            return null;
        }

        // 递归翻转左右子树
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // 翻转左右子树的位置
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTreeTwo(TreeNode root) {
        // 广度优先遍历 层层遍历
        if (null == root) {
            return null;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        while (!nodeList.isEmpty()) {
            // 交换当前节点的左右子树
            TreeNode temp = nodeList.poll();
            TreeNode left = temp.left;
            temp.left = temp.right;
            temp.right = left;

            // 迭代左右子树
            if (temp.left != null) {
                nodeList.add(temp.left);
            }

            if (temp.right != null) {
                nodeList.add(temp.right);
            }
        }
        return root;
    }

    class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
