package com.xinxin.zzlz.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Description: 说说下面程序的结果
 * @Date: 2020/5/9
 * @Version: 1.0
 */
public class VolatileTest {
    public static volatile int race = 0;

    public static void increase(){
        race++;
    }
    private static final int THREADS_COUNT = 10;

    public static void main(String[] args) {
        // 获取java线程的管理MXBean
        ThreadMXBean tmxb = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的Monitor和synchronizer信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = tmxb.dumpAllThreads(false, false);
        // 遍历线程信息，打印出ID和名称
        for (ThreadInfo info : threadInfos) {
            System.out.println("[" + info.getThreadId() + "] " + info.getThreadName());
        }

        Thread.currentThread().getThreadGroup().list();

        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
       while (Thread.activeCount()>1){
           Thread.yield();
       }
        System.out.println(race);
    }

}
