package com.ral.admin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: RenYunHui
 * @Date: 2021-04-18 10:03
 * @Describe:
 * @Modify:
 */
public class Demo {

    public static void main(String[] args) {
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int num = 1;
        int count = 0;
        nodeList.add(root);
        while (!nodeList.isEmpty()) {
            if (nodeList.get(0) != null) {
                temp.add(nodeList.get(0).val);
                nodeList.add(nodeList.get(0).left);
                nodeList.add(nodeList.get(0).right);
            }
            nodeList.remove(0);
            count++;
            // 计数器达到了当前层的元素个数
            if (count == num && !temp.isEmpty()) {
                result.add(temp);
                temp = new ArrayList<>();
                count = 0;
                // 更新每一层的元素个数（关键）
                num = nodeList.size();
            }
        }
        return result;
    }

    public List<List<Integer>> levelOrderTwo(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            nodeQueue.add(root);
        }
        while (!nodeQueue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = nodeQueue.size(); i > 0; i--) {
                TreeNode node = nodeQueue.poll();
                if (null != node) {
                    tmp.add(node.val);
                    if (node.left != null) {
                        nodeQueue.add(node.left);
                    }
                    if (node.right != null) {
                        nodeQueue.add(node.right);
                    }
                }
            }
            result.add(tmp);
        }
        return result;
    }

    public int[] levelOrderThree(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public List<List<Integer>> levelOrderFour(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            nodeQueue.add(root);
        }
        while (!nodeQueue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = nodeQueue.size(); i > 0; i--) {
                TreeNode node = nodeQueue.poll();
                if (node != null) {
                    if (result.size() % 2 == 0) {
                        // 偶数 2 4 6 ...  头部
                        tmp.addLast(node.val);
                    } else {
                        // 奇数 1 3 5 ... 尾部
                        tmp.addFirst(node.val);
                    }
                    if (node.left != null) {
                        nodeQueue.add(node.left);
                    }
                    if (node.right != null) {
                        nodeQueue.add(node.right);
                    }
                }
            }
            result.add(tmp);
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

