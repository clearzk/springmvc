package com.ai.mvc.interview.basic.juc.tmp;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo implements Runnable{

    private AtomicInteger atomicInteger=new AtomicInteger();

    public int getI() {
        return atomicInteger.getAndIncrement();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getI());
    }
}
