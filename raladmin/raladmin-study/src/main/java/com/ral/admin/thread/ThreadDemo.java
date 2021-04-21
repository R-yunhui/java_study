/*
 * @projectName raladmin
 * @package com.ral.admin.thread
 * @className com.ral.admin.thread.ThreadDemo
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.thread;

import java.util.concurrent.CyclicBarrier;

import lombok.extern.slf4j.Slf4j;

/**
 * ThreadDemo
 * @Description ThreadDemo
 * @author renyunhui
 * @date 2021/4/12 9:11
 * @version 1.0
 */
@Slf4j
public class ThreadDemo {

    private final static int ATHLETES = 20;
    private static CyclicBarrier cyclicBarrier;

    public static void main(String[] args) {
        cyclicBarrier = new CyclicBarrier(ATHLETES, () -> log.info("所有运动员已到齐,比赛开始！！"));

        for (int i = 0; i < ATHLETES; i++) {
            new CyclicBarrierThread().start();
        }
    }

    static class CyclicBarrierThread extends Thread {
        @Override
        public void run() {
            log.info("运动员：{} 到场", Thread.currentThread().getName());
            log.info("当前在等待的运动员为:" + cyclicBarrier.getNumberWaiting());
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
