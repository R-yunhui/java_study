package com.ral.admin.tree;

import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: RenYunHui
 * @Date: 2021-04-26 21:34
 * @Describe: 组织树构建
 * @Modify:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganTree {

    private int id;
    private int pid;
    private boolean isLeaf;
    private String name;
    private List<OrganTree> children;

    public static void main(String[] args) {
        OrganTree root = new OrganTree(1, 0, false, "中国", null);
        OrganTree treeOne = new OrganTree(2, 1, false, "北京市", null);
        OrganTree treeTwo = new OrganTree(3, 1, false, "四川省", null);
        OrganTree treeThree = new OrganTree(4, 2, true, "海淀区", null);
        OrganTree treeFour = new OrganTree(5, 2, true, "顺义区", null);
        OrganTree treeFive = new OrganTree(6, 3, false, "成都市", null);
        OrganTree treeSix = new OrganTree(7, 3, true, "绵阳市", null);
        OrganTree treeSeven = new OrganTree(8, 6, true, "武侯区", null);
        OrganTree treeEight = new OrganTree(9, 6, true, "高新区", null);
        List<OrganTree> organTrees = new ArrayList<>();
        organTrees.add(root);
        organTrees.add(treeOne);
        organTrees.add(treeTwo);
        organTrees.add(treeThree);
        organTrees.add(treeFour);
        organTrees.add(treeFive);
        organTrees.add(treeSix);
        organTrees.add(treeSeven);
        organTrees.add(treeEight);
        System.err.println(JSONUtil.toJsonStr(createOrganTree(organTrees)));
    }

    private static List<OrganTree> createOrganTree(List<OrganTree> organTrees) {
        // 先将所有子树进行分组
        Map<Integer, List<OrganTree>> subMap = organTrees.stream().filter(x -> x.getPid() != 0).collect(Collectors.groupingBy(OrganTree::getPid));

        // 将对应的子树的集合放入对应的父级树的子树集合中
        organTrees.forEach(organTree -> organTree.setChildren(subMap.get(organTree.getId())));

        // 只保留根节点完整的树结构
        return organTrees.stream().filter(x -> x.getPid() == 0).collect(Collectors.toList());
    }
}
