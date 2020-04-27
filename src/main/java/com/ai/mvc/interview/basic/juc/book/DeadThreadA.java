package com.ai.mvc.interview.basic.juc.book;

public class DeadThreadA extends Thread{
    private DeadLock deadLock;

    public DeadThreadA(DeadLock deadLock) {
        this.deadLock = deadLock;
    }

    @Override
    public void run() {
        deadLock.add();
    }
}
