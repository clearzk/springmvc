package com.ai.mvc.interview.basic.juc.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    public static void main(String[] args) {
//        singleThread();
//        cachedThread();
        fixedThread();
    }

    public static void singleThread() {
        ExecutorService executorService=Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int no=i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("start: " + no);
                        Thread.sleep(1000);
                        System.out.println("end: " + no);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
        System.out.println("main thread end");
    }

    public static void cachedThread() {
        ExecutorService service=Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            final int no=i;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("start: " + no);
                        Thread.sleep(1000);
                        System.out.println("end: " + no);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }

        service.shutdown();
        System.out.println("main thread end");
    }

    public static void fixedThread() {
        ExecutorService service=Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            final int no=i;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("start: " + no);
                        Thread.sleep(1000);
                        System.out.println("end: " + no);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
        service.shutdown();
        System.out.println("main thread end");
    }

}
