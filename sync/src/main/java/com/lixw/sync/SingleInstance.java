package com.lixw.sync;

/**
 * @author lixw
 * @date 2020/10/22
 */
public class SingleInstance {


    private static volatile SingleInstance singleInstance;//volatile必需，防止对象创建时指令重排序

    private SingleInstance() {

    }

    public static SingleInstance getInstance() {
        //DCL(double check lock)
        if (singleInstance == null) {
            synchronized (SingleInstance.class) {
                if (singleInstance == null) {
                    singleInstance = new SingleInstance();
                }
            }
        }
        return singleInstance;
    }

    public static void main(String[] args) {
        int[] s = resolve("RGBY", "RGBB");
        System.out.printf("[%s,%s]",s[0], s[1]);
        int i =0;
//        for (int i1 = 0; i1 < 5; i1++) {
//            System.out.println("i1 = " + i1);
//        }
//        for (int i1 = 0; i1 < 5; ++i) {
//            System.out.println("i1 = " + i1);
//        }
    }


    public static int[] resolve(String solution, String guess) {
        if (solution.equals(guess)) {
            return new int[] {4, 0};
        }
        int w = 0;
        int o = 4;
        char s1 = solution.charAt(0);
        char s2 = solution.charAt(1);
        char s3 = solution.charAt(2);
        char s4 = solution.charAt(3);
        char g1 = guess.charAt(0);
        char g2 = guess.charAt(1);
        char g3 = guess.charAt(2);
        char g4 = guess.charAt(3);
        if (s1 != g1) {
            w++;
            o--;
        }
        if (s2 != g2) {
            w++;
            o--;
        }
        if (s3 != g3) {
            w++;
            o--;
        }
        if (s4 != g4) {
            w++;
            o--;
        }
        if (g1 == g2) {
            w--;
        }
        if (g1 == g3) {
            w--;
        }
        if (g1 == g4) {
            w--;
        }
        if (g2 == g3) {
            w--;

        }
        if (g2 == g4) {
            w--;
        }
        if (g3 == g4) {
            w--;
        }
        return new int[] {o, w};
    }
}
