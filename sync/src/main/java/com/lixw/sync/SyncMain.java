package com.lixw.sync;

import com.lixw.sync.invoke.AutoWired;
import com.sun.tools.javac.util.Assert;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * @author lixw
 * @date 2020/10/21
 */
public class SyncMain {

    private static int m = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        final CountDownLatch latch = new CountDownLatch(threads.length);
        Object o = new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                synchronized (o) {
                    for (int i1 = 0; i1 < 10000; i1++) {
                        m++;
                    }
                    latch.countDown();
                }
            });
        }
        Charset.forName("utf-8");
        Arrays.stream(threads).forEach(item -> item.start());

        latch.await();

        System.out.println("m = " + m);
    }
}
