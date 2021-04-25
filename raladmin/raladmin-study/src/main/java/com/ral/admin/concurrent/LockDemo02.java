/*
 * @projectName raladmin
 * @package com.ral.admin.concurrent
 * @className com.ral.admin.concurrent.LockDemo02
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.concurrent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import lombok.extern.slf4j.Slf4j;

/**
 * LockDemo02
 * @Description lock实现生产者消费者模型
 * @author renyunhui
 * @date 2021/4/25 11:43
 * @version 1.0
 */
@Slf4j
public class LockDemo02 {

    private static final ReentrantLock nonFairLock = new ReentrantLock();
    /** 队列满的条件 */
    private Condition fullCondition = nonFairLock.newCondition();
    /** 队列不满的条件 */
    private Condition nonFullCondition = nonFairLock.newCondition();
    /** 生产容器 */
    private List<String> bufferList = new ArrayList<>();
    /** 最大容量 */
    private int maxSize;

    public LockDemo02(int maxSize) {
        this.maxSize = maxSize;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor consumerPool = new ThreadPoolExecutor(5, 10, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1024), new ThreadFactoryBuilder().setNameFormat("producer-%d").build());
        ThreadPoolExecutor producerPool = new ThreadPoolExecutor(5, 10, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1024), new ThreadFactoryBuilder().setNameFormat("consumer-%d").build());
        LockDemo02 lockDemo02 = new LockDemo02(10);
        for (int i = 0; i < lockDemo02.maxSize; i++) {
            consumerPool.execute(lockDemo02.new Consumer());
            producerPool.execute(lockDemo02.new Producer());
        }
        consumerPool.shutdown();
        producerPool.shutdown();
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            try {
                nonFairLock.lock();
                // 满了
                while (maxSize == bufferList.size()) {
                    log.info(Thread.currentThread().getName() + "：当前队列已满，不在进行生产...");
                    nonFullCondition.await();
                }
                bufferList.add("producer");
                log.info(Thread.currentThread().getName() + "：生产了，当前队列大小为" + bufferList.size());
                fullCondition.signal();
            } catch (Exception e) {
                log.info("生产者执行任务失败" + e);
            } finally {
                nonFairLock.unlock();
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            try {
                nonFairLock.lock();
                // 空了
                while (bufferList.isEmpty()) {
                    log.info(Thread.currentThread().getName() + "：当前队列已空，不在进行消费...");
                    fullCondition.await();
                }
                log.info(Thread.currentThread().getName() + "：消费了，当前队列大小为" + bufferList.size());
                bufferList.remove(0);
                nonFullCondition.signal();
            } catch (Exception e) {
                log.info("消费者执行任务失败" + e);
            } finally {
                nonFairLock.unlock();
            }
        }
    }

}
