package com.ral.admin.leetcode.day14;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: RenYunHui
 * @Date: 2021-04-25 21:24
 * @Describe: 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * @Modify:
 */
public class Demo01 {

    public static void main(String[] args) {
        TreeNode treeNode9 = new TreeNode(1, null, null);
        TreeNode treeNode8 = new TreeNode(2, treeNode9, null);
        TreeNode treeNode7 = new TreeNode(4, null, null);
        TreeNode treeNode6 = new TreeNode(3, treeNode8, treeNode7);
        TreeNode treeNode5 = new TreeNode(7, null, null);
        TreeNode treeNode4 = new TreeNode(9, null, null);
        TreeNode treeNode3 = new TreeNode(8, treeNode5, treeNode4);
        TreeNode treeNode2 = new TreeNode(6, null, treeNode3);
        TreeNode treeNode = new TreeNode(5, treeNode6, treeNode2);
        new Demo01().increasingBST(treeNode);
    }

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // 中序遍历 将值存入list
        inorder(root, res);

        // 遍历创建二叉树（只含右节点的）
        TreeNode dummyNode = new TreeNode(-1);
        TreeNode currNode = dummyNode;
        for (int value : res) {
            currNode.right = new TreeNode(value);
            currNode = currNode.right;
        }
        return dummyNode.right;
    }

    public void inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }
}

class TreeNode {
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