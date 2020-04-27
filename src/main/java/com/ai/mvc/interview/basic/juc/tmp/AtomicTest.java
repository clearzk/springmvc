package com.ai.mvc.interview.basic.juc.tmp;

public class AtomicTest {

    public static void main(String[] args) {
        AtomicDemo atomicDemo=new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(atomicDemo).start();
        }
    }
}
