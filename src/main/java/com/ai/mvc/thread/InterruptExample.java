package com.ai.mvc.thread;

public class InterruptExample {

    public static class MyThread1 extends Thread{

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread=new MyThread1();
        thread.start();
        thread.interrupt();
        System.out.println("main run ...");
    }
}
