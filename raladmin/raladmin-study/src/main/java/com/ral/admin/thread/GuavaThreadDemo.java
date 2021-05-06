/*
 * @projectName raladmin
 * @package com.ral.admin.thread
 * @className com.ral.admin.thread.GuavaThreadDemo
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.thread;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import lombok.extern.slf4j.Slf4j;

/**
 * GuavaThreadDemo
 * @Description
 * @author renyunhui
 * @date 2021/3/17 14:18
 * @version 1.0
 */
@Slf4j
public class GuavaThreadDemo {

    private static ListeningExecutorService executorService = MoreExecutors.listeningDecorator(ThreadUtil.createThreadPool());

    public static void main(String[] args) {
        ListenableFuture<Object> listenableFuture = executorService.submit(() -> {
            log.debug("线程:{} 执行中", Thread.currentThread().getName());
            return "123";
        });

        Futures.addCallback(listenableFuture, new FutureCallback<Object>() {
            @Override
            public void onSuccess(@Nullable Object o) {
                log.info("调用成功:{}", o);
            }

            @Override
            public void onFailure(Throwable throwable) {
                log.error("任务执行失败:{}", throwable);
            }
        }, executorService);
    }
}
