package com.ai.mvc.interview.basic.juc.tmp;

public class ThreadDemo implements Runnable {

    public volatile boolean flag=false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("ThreadDemo线程修改后的flag = " + isFlag());
    }

    public boolean isFlag() {
        return flag;
    }

}
