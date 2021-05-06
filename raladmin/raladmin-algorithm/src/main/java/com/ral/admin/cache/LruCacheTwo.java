/*
 * @projectName raladmin
 * @package com.ral.admin.cache
 * @className com.ral.admin.cache.LRUCache
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRUCache
 * @Description LRU算法 缓存淘汰策略  leetcode 146. LRU 缓存机制  基于LinkedHashMap实现LRU算法 淘汰最近最少使用的
 * @author renyunhui
 * @date 2021/4/28 14:55
 * @version 1.0
 */
public class LruCacheTwo extends LinkedHashMap<Integer, Integer> {

    /** 缓存的容量 */
    private int capacity;

    public LruCacheTwo(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
