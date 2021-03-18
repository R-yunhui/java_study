/*
 * @projectName raladmin
 * @package com.ral.admin.tree
 * @className com.ral.admin.tree.BinaryTreeNode
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.tree;

import lombok.Data;

/**
 * BinaryTreeNode
 * @Description 二叉树结构
 * @author renyunhui
 * @date 2021/3/12 16:52
 * @version 1.0
 */
@Data
public class BinaryTreeNode {

    /** 数据 */
    private Integer data;

    /** 左子树 */
    private BinaryTreeNode leftChildTree;

    /** 右子树 */
    private BinaryTreeNode rightChildTree;
}
