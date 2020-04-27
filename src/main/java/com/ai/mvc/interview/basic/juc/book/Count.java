package com.ai.mvc.interview.basic.juc.book;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Count  {

    private final ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    //读
    public void get() {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + ":get start ...");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ":get end ...");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
    }

    //写
    public void put() {

        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + ":put start ...");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ":put end ...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

}
