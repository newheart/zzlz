package com.xinxin.zzlz.thread;

import java.util.concurrent.*;

/**
 * @Description:
 * @Date: 2020/5/9
 * @Version: 1.0
 */
public class CountDownTask {
    private static final int CORE_POOL_SIZE = 4;
    private static final int MAX_POOL_SIZE = 12;
    private static final long KEEP_ALIVE_TIME = 5L;
    private final static int QUEUE_SIZE = 1600;

    protected final static ExecutorService THREAD_POOL = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE,
            KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingQueue<>(QUEUE_SIZE));
    public static void main(String[] args) throws InterruptedException {
        // 新建一个为5的计数器
        CountDownLatch countDownLatch = new CountDownLatch(5);
        THREAD_POOL.execute(() -> {
            System.out.println("当前任务Customer,线程名字为:" + Thread.currentThread().getName());
            countDownLatch.countDown();
        });
        THREAD_POOL.execute(() -> {
            System.out.println("当前任务Discount,线程名字为:" + Thread.currentThread().getName());
            countDownLatch.countDown();
        });
        THREAD_POOL.execute(() -> {
            System.out.println("当前任务Food,线程名字为:" + Thread.currentThread().getName());
            countDownLatch.countDown();
        });
        THREAD_POOL.execute(() -> {
            System.out.println("当前任务Tenant,线程名字为:" + Thread.currentThread().getName());
            countDownLatch.countDown();
        });
        THREAD_POOL.execute(() -> {
            System.out.println("当前任务OtherInfo,线程名字为:" + Thread.currentThread().getName());
            countDownLatch.countDown();
        });
        countDownLatch.await(3, TimeUnit.SECONDS);
        System.out.println("主线程："+ Thread.currentThread().getName());
    }
}