package com.ai.mvc.interview.basic.pattern.strategy;

import java.util.Random;

public class Client {
    public static void main(String[] args) {

        Random random=new Random();


        int seed1=random.nextInt(3);
        int seed2=random.nextInt(3);

        Player p1=new Player("zk",new WinningStrategy(seed1));
        Player p2=new Player("wd",new PropStrategy(seed2));

        for (int i = 0; i < 10000; i++) {
            Hand nextHand1 = p1.nextHand();
            Hand nextHand2 = p2.nextHand();
            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner:" + p1);
                p1.win();
                p2.lose();
            } else if (nextHand2.isStrongerThan(nextHand1)) {
                System.out.println("Winner:" + p2);
                p2.win();
                p1.lose();
            } else {
                System.out.println("Even...");
                p1.even();
                p2.even();
            }
        }

        System.out.println("Total reuslt:");

        System.out.println(p1);
        System.out.println(p2);

    }
}
