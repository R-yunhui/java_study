package com.ral.admin.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: RenYunHui
 * @Date: 2021-04-26 20:37
 * @Describe:
 * @Modify:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BinaryTreeNode {

    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }
}
