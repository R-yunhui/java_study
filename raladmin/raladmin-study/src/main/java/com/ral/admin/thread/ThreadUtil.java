/*
 * @projectName raladmin
 * @package com.ral.admin.thread
 * @className com.ral.admin.thread.Demo01
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * Demo01
 * @Description
 * @author renyunhui
 * @date 2021/3/17 13:49
 * @version 1.0
 */
public class ThreadUtil {

    /** 核心线程数 */
    private static final Integer CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();

    /** 最大线程数 */
    private static final Integer MAX_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2;

    /** 当线程池中的数量多于核心线程数时，空闲线程超时失活时间 单位秒 */
    private static final Long KEEP_ALIVE_TIME = 30L;

    /** 线程池中工作队列的容量 */
    private static final Integer MAX_WORK_QUEUE_SIZE = 1024;

    public static ThreadPoolExecutor createThreadPool() {
        ThreadFactory namedFactory = new ThreadFactoryBuilder().setNameFormat("work-thread-pool-").build();
        return new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(MAX_WORK_QUEUE_SIZE), namedFactory, new ThreadPoolExecutor.AbortPolicy());
    }
}
