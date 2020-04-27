package com.ai.mvc.interview.basic.juc.tmp;

public class AlternationTest {

    public static void main(String[] args) {
        AlternationDemo alternationDemo=new AlternationDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    alternationDemo.loopA();
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    alternationDemo.loopB();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    alternationDemo.loopC();
                }
            }
        },"C").start();
    }

}
