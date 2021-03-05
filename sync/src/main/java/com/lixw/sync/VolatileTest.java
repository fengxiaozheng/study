package com.lixw.sync;

import java.util.concurrent.TimeUnit;

/**
 * @author lixw
 * @date 2020/10/22
 */
public class VolatileTest {
    public volatile boolean isRunning = true;

    void test() {
        System.out.println("start");
        while (isRunning) {
            //打印语句会同步主内存数据
        //    System.out.println("hello");
        }
        System.out.println("end");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest  test = new VolatileTest();
        new Thread(test::test).start();
        TimeUnit.SECONDS.sleep(1L);
        test.isRunning = false;

    }
}
