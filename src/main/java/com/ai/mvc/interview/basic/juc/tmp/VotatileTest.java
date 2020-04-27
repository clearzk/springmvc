package com.ai.mvc.interview.basic.juc.tmp;

public class VotatileTest {


    public static void main(String[] args) {
        ThreadDemo threadDemo=new ThreadDemo();
        Thread thread=new Thread(threadDemo);
        thread.start();
        while (true) {
            if (threadDemo.isFlag()) {
                System.out.println("主线程读取到的flag值为：" + threadDemo.isFlag());
                break;
            }
        }
    }

}
