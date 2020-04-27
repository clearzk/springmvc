package com.ai.mvc.interview.basic.juc.tmp;

import java.util.concurrent.CountDownLatch;

public class LatchDemo implements Runnable {

    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch=latch;
    }

    public LatchDemo() {
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5000; i++) {

                    if (i % 2 == 0) {
                        System.out.println(i);
                    }

                }
            }finally {
                latch.countDown();
            }

        }

    }
}
