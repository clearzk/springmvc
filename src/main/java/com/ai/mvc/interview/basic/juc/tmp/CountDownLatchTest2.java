package com.ai.mvc.interview.basic.juc.tmp;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest2 {

    public static void main(String[] args) {
        final CountDownLatch latch=new CountDownLatch(10);
        LatchDemo ld=new LatchDemo(latch);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(ld).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end=System.currentTimeMillis();
        System.out.println("耗费时间为：" + (end - start) + "秒");
    }
}
