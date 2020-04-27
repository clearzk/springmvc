package com.ai.mvc.interview.basic.juc.tmp;

public class CountDownLatchTest {

    public static void main(String[] args) {
        LatchDemo latchDemo=new LatchDemo();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(latchDemo).start();
        }
        long end=System.currentTimeMillis();
        System.out.println("耗费时间为：" + (end - start) + "秒");
    }
}
