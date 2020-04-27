package com.ai.mvc.interview.basic.juc.book;

public class DeadLockTest {
    public static void main(String[] args) {
        DeadLock deadLock=new DeadLock();
        DeadThreadA dtA=new DeadThreadA(deadLock);
        DeadThreadB dtB=new DeadThreadB(deadLock);
        dtA.start();
        dtB.start();

    }
}
