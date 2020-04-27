package com.ai.mvc.interview.basic.juc.tmp;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AlternationDemo {
    //当前正在执行的线程标记
    private int number=1;

    final Lock lock=new ReentrantLock();

    private Condition condition1=lock.newCondition();
    private Condition condition2=lock.newCondition();
    private Condition condition3=lock.newCondition();

    public void loopA() {
        lock.lock();
        try {
            if (number != 1) {//判断当前执行的线程不是1则等待
                condition1.await();
            }
            //打印
            System.out.println(Thread.currentThread().getName());
            number=2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void loopB() {
        lock.lock();
        try {
            if (number != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName());
            number=3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void loopC() {
        lock.lock();
        try {
            if (number != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName());
            number=1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

}
