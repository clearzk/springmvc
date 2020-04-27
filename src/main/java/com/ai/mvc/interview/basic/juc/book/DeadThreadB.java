package com.ai.mvc.interview.basic.juc.book;

public class DeadThreadB extends Thread{
    private DeadLock deadLock;

    public DeadThreadB(DeadLock deadLock) {
        this.deadLock = deadLock;
    }

    @Override
    public void run() {
        deadLock.increase();
    }
}
