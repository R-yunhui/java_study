package com.ral.admin.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: RenYunHui
 * @Date: 2021-04-26 20:35
 * @Describe: 二叉树
 * @Modify:
 */
public class BinaryTree {

    public static void main(String[] args) {
        BinaryTreeNode leftThree = new BinaryTreeNode(7);
        BinaryTreeNode leftTwo = new BinaryTreeNode(6);
        BinaryTreeNode rightThree = new BinaryTreeNode(5);
        BinaryTreeNode rightTwo = new BinaryTreeNode(4);
        BinaryTreeNode right = new BinaryTreeNode(3, leftThree, rightThree);
        BinaryTreeNode left = new BinaryTreeNode(2, leftTwo, rightTwo);
        BinaryTreeNode root = new BinaryTreeNode(1, left, right);
        BinaryTree binaryTree = new BinaryTree();
        System.err.println("前序递归遍历二叉树：");
        binaryTree.preOrder(root);
        System.err.println("\n前序非递归遍历二叉树：");
        binaryTree.preOrderNonRecursive(root);
        System.err.println("\n\n中序递归遍历二叉树：");
        binaryTree.inOrder(root);
        System.err.println("\n中序非递归遍历二叉树：");
        binaryTree.inOrderNonRecursive(root);
        System.err.println("\n\n后序递归遍历二叉树：");
        binaryTree.portOrder(root);
        System.err.println("\n后序非递归遍历二叉树：");
        binaryTree.portOrderNonRecursive(root);
        System.err.println("\n\n层次遍历二叉树（广度优先遍历）");
        binaryTree.levelOrder(root);
        System.err.println("\n\n深度优先遍历二叉树");
        binaryTree.depthOrder(root);
    }

    /**
     * 前序遍历（递归）
     * 访问根结点 --> 递归遍历根结点的左子树 --> 递归遍历根结点的右子树
     *
     * @param root 二叉树根节点
     */
    public void preOrder(BinaryTreeNode root) {
        if (null != root) {
            System.err.print(root.getData() + "\t");
            // 依次递归遍历左子树和右子树
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    /**
     * 前序遍历（非递归）
     * 访问根结点 --> 递归遍历根结点的左子树 --> 递归遍历根结点的右子树
     *
     * @param root 二叉树根节点
     */
    public void preOrderNonRecursive(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                System.err.print(root.getData() + "\t");
                stack.push(root);
                root = root.getLeft();
            }

            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            root = root.getRight();
        }
    }

    /**
     * 中序遍历（递归）
     * 递归遍历根结点的左子树 --> 访问根结点 --> 递归遍历根结点的右子树
     *
     * @param root 二叉树根节点
     */
    public void inOrder(BinaryTreeNode root) {
        if (null != root) {
            // 先递归遍历左子树
            inOrder(root.getLeft());
            System.err.print(root.getData() + "\t");
            // 再递归遍历所有的右子树
            inOrder(root.getRight());
        }
    }

    /**
     * 中序遍历（非递归）
     * 递归遍历根结点的左子树 --> 访问根结点 --> 递归遍历根结点的右子树
     *
     * @param root 二叉树根节点
     */
    public void inOrderNonRecursive(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            System.err.print(root.getData() + "\t");
            root = root.getRight();
        }
    }

    /**
     * 后序遍历（递归）
     * 递归遍历根结点的左子树 --> 递归遍历根结点的右子树 -->访问根结点
     *
     * @param root 二叉树根节点
     */
    public void portOrder(BinaryTreeNode root) {
        if (null != root) {
            // 先递归遍历左子树
            portOrder(root.getLeft());
            // 再递归遍历所有的右子树
            portOrder(root.getRight());
            System.err.print(root.getData() + "\t");
        }
    }

    /**
     * 后序遍历（非递归）
     * 递归遍历根结点的左子树 --> 递归遍历根结点的右子树 -->访问根结点
     *
     * @param root 二叉树根节点
     */
    public void portOrderNonRecursive(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.getLeft();
            } else {
                if (stack.isEmpty()) {
                    return;
                }

                if (null == stack.lastElement().getRight()) {
                    root = stack.pop();
                    System.err.print(root.getData() + "\t");
                    while (root == stack.lastElement().getRight()) {
                        System.err.print(stack.lastElement().getData() + "\t");
                        root = stack.pop();
                        if (stack.isEmpty()) {
                            break;
                        }
                    }
                }

                if (!stack.isEmpty()) {
                    root = stack.lastElement().getRight();
                } else {
                    root = null;
                }
            }
        }
    }

    /**
     * 层次遍历 广度优先遍历
     * @param root  二叉树根节点
     */
    public void levelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp;
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            System.err.print(temp.getData() + "\t");
            // 从左到右依次入队列
            if (null != temp.getLeft()) {
                queue.offer(temp.getLeft());
            }

            if (null != temp.getRight()) {
                queue.offer(temp.getRight());
            }
        }
    }

    /**
     * 深度优先遍历
     * @param root  二叉树根节点
     */
    public void depthOrder(BinaryTreeNode root) {
        BinaryTreeNode temp;
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            temp = queue.pop();
            System.err.print(temp.getData() + "\t");
            // 从左到右依次入栈
            if (null != temp.getLeft()) {
                queue.push(temp.getLeft());
            }

            if (null != temp.getRight()) {
                queue.push(temp.getRight());
            }
        }
    }
}
