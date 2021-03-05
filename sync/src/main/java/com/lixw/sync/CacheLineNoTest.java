package com.lixw.sync;

import java.util.concurrent.CountDownLatch;

/**
 * @author lixw
 * @date 2020/10/22
 */
public class CacheLineNoTest {

    public static long COUNT = 1_0000_0000L;

    private static class T {
        public volatile long x = 0L;
    }

    public static T[] ts = new T[2];

    static {
        ts[0] = new T();
        ts[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        Thread thread1 = new Thread(() -> {
            for (long i = 0; i < COUNT; i++) {
                ts[0].x = i;
            }
            latch.countDown();
        });
        Thread thread2 = new Thread(() -> {
            for (long i = 0; i < COUNT; i++) {
                ts[1].x = i;
            }
            latch.countDown();
        });

        final long start = System.nanoTime();
        thread1.start();
        thread2.start();
        latch.await();
        System.out.println((System.nanoTime() - start)/100_0000);
    }
}
