package com.lixw.sync;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lixw
 * @date 2020/10/21
 */
public class SyncAtomicInteger {

    private JOLTest jolTest;

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int i1 = 0; i1 < 10000; i1++) {
                    atomicInteger.getAndIncrement();
                }

                latch.countDown();
            });
        }

        Arrays.stream(threads).forEach(Thread::start);
        latch.await();
        System.out.println("atomicInteger.get() = " + atomicInteger.get());
    }


    public JOLTest getJolTest() {
        return jolTest;
    }

    public void setJolTest(JOLTest jolTest) {
        this.jolTest = jolTest;
    }

}
