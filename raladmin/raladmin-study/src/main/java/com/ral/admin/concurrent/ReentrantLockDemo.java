/*
 * @projectName raladmin
 * @package com.ral.admin.concurrent
 * @className com.ral.admin.concurrent.ReentranLockDemo
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

/**
 * ReentranLockDemo
 * @Description
 * @author renyunhui
 * @date 2021/4/25 11:05
 * @version 1.0
 */
@Slf4j
public class ReentrantLockDemo {

    /** 构建非公平锁 */
    private static final ReentrantLock nonFairLock = new ReentrantLock();
    private static final Condition condition = nonFairLock.newCondition();

    public static void main(String[] args) {
        Thread await = new Thread(() -> {
            try {
                // 先获取锁 获得对象监视器
                nonFairLock.lock();
                log.info(Thread.currentThread().getName() + "获取到锁：" + nonFairLock.isLocked());
                log.info(Thread.currentThread().getName() + "等待通知.....");
                // await 和 signal对应
                condition.await();
                log.info(Thread.currentThread().getName() + "等到通知，继续执行");
            } catch (Exception e) {
                log.error("任务执行失败" + e);
            } finally {
                // 释放锁
                nonFairLock.unlock();
            }
        });

        Thread signal = new Thread(() -> {
            try {
                // 先获取锁 获得对象监视器
                nonFairLock.lock();
                log.info(Thread.currentThread().getName() + "获取到锁：" + nonFairLock.isLocked());
                log.info(Thread.currentThread().getName() + "通知在等待的锁.....");
                // await 和 signal对应
                condition.signal();
                Thread.sleep(1000L);
                log.info(Thread.currentThread().getName() + "通知完毕");
            } catch (Exception e) {
                log.error("任务执行失败" + e);
            } finally {
                // 释放锁
                nonFairLock.unlock();
            }
        });

        await.start();
        signal.start();
    }
}
