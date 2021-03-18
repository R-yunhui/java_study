/*
 * @projectName raladmin
 * @package com.ral.admin.tree
 * @className com.ral.admin.tree.BinaryTree
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.tree;

/**
 * BinaryTree
 * @Description 二叉树
 * @author renyunhui
 * @date 2021/3/12 16:55
 * @version 1.0
 */
public class BinaryTree {

    private BinaryTreeNode root;

    /** 初始化空二叉树 */
    public BinaryTree() {
    }

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }
}
