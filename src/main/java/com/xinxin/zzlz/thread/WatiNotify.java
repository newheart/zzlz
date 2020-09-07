package com.xinxin.zzlz.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Date: 2020/8/4
 * @Version: 1.0
 */
public class WatiNotify {
    public static void main(String[] args) {
        Object object = new Object();
         final  AtomicInteger count =new AtomicInteger(1);
        Thread thread1 = new Thread(()->{

            synchronized (object) {
                while (count.intValue() <= 100)
                    if (count.intValue() % 2 == 1) {
                        System.out.println(count.getAndIncrement());

                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        object.notify();
                    }
            }
        });
        Thread thread2 = new Thread(()->{

            synchronized (object) {
                while (count.intValue() <= 100)
                    if (count.intValue() % 2 == 0) {
                        System.out.println(count.getAndIncrement());

                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        object.notify();
                    }
            }
        });
        thread1.start();
        thread2.start();

    }
}
