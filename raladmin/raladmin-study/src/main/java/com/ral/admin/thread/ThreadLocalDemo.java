package com.ral.admin.thread;

/**
 * ThreadLocalDemp
 * @Description
 * @author renyunhui
 * @date 2021/4/15 9:14
 * @version 1.0
 */
public class ThreadLocalDemo {

    private static ThreadLocal<String> sThreadLocal = new ThreadLocal();

    public static void main(String[] args) {
        sThreadLocal.set("这是在主线程中");
        System.out.println("线程名字：" + Thread.currentThread().getName() + "---" + sThreadLocal.get());

        // 线程a
        new Thread(() -> {
            // 1.获取当前线程  Thread t = Thread.currentThread();
            // 2.获取当前线程的ThreadLocalMap  ThreadLocalMap map = getMap(t);
            // 3.将ThreadLocal和value放入当前线程的ThreadLocalMap中  map.set(this, value);
            sThreadLocal.set("这是在线程a中");
            System.out.println("线程名字：" + Thread.currentThread().getName() + "---" + sThreadLocal.get());
        }, "线程a").start();

        // 线程b
        new Thread(() -> {
            sThreadLocal.set("这是在线程b中");
            System.out.println("线程名字：" + Thread.currentThread().getName() + "---" + sThreadLocal.get());
        }, "线程b").start();

        // 线程c
        new Thread(() -> {
            sThreadLocal.set("这是在线程c中");
            System.out.println("线程名字：" + Thread.currentThread().getName() + "---" + sThreadLocal.get());
        }, "线程c").start();

    }
}
