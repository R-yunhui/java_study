/*
 * @projectName raladmin
 * @package com.ral.admin.cache
 * @className com.ral.admin.cache.LRUCache
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * LRUCache
 * @Description LRU算法 缓存淘汰策略  leetcode 146. LRU 缓存机制
 * @author renyunhui
 * @date 2021/4/28 14:55
 * @version 1.0
 */
public class LruCache {

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Map<Integer, Node> cache = new HashMap<>();
    private int size;
    private final int capacity;
    private final Node head;
    private final Node tail;

    public LruCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，将当前节点移除，在将此节点移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            Node newNode = new Node(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                Node tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 将当前的node节点添加head节点后面
     * @param node node节点
     */
    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 移除当前的node节点
     * @param node node节点
     */
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 移除当前节点并将此节点添加到head节点后面
     * @param node node节点
     */
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 移除末尾的节点
     * @return 移除的节点
     */
    private Node removeTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }
}
