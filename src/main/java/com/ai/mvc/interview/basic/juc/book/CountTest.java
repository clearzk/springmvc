package com.ai.mvc.interview.basic.juc.book;

public class CountTest {
    public static void main(String[] args) {
        final Count count=new Count();
        for (int i = 0; i < 5; i++) {
            new Thread("A"){
                @Override
                public void run() {
                    count.get();
                }
            }.start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread("B"){
                @Override
                public void run() {
                    count.put();
                }
            }.start();
        }
    }
}
