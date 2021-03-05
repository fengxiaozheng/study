package com.lixw.sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author lixw
 * @date 2020/10/22
 */
public class JOLTest {

    public static void main(String[] args) {
        T o = new T();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }


    private static class T {
        long integer;
    }

}
