package org.example.algorithm.demo03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-23 20:41
 * @Describe: 嵌套的整型列表是一个树形结构，树上的叶子节点对应一个整数，非叶节点对应一个列表。
 * 在这棵树上深度优先搜索的顺序就是迭代器遍历的顺序。
 * 我们可以先遍历整个嵌套列表，将所有整数存入一个数组，然后遍历该数组从而实现 \texttt{next}next 和 \texttt{hasNext}hasNext 方法。
 * @Modify:
 */
public class NestedIterator implements Iterator<Integer> {

    private final List<Integer> val;
    private final Iterator<Integer> cur;

    public NestedIterator(List<NestedInteger> nestedList) {
        val = new ArrayList<>();
        dfs(nestedList);
        cur = val.iterator();
    }

    @Override
    public Integer next() {
        return cur.next();
    }

    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                val.add(nest.getInteger());
            } else {
                dfs(nest.getList());
            }
        }
    }
}
