package com.ai.mvc.interview.basic.pattern.strategy;

public class Player {
    private String name;
    private Strategy strategy;
    private int wonCount;
    private int loseCount;
    private int evenCount;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public Hand nextHand() {
        return strategy.nextHand();
    }

    public void win() {
        strategy.study(true);
        wonCount++;
    }

    public void lose() {
        strategy.study(false);
        loseCount++;
    }

    public void even() {
        evenCount++;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", wonCount=" + wonCount +
                ", loseCount=" + loseCount +
                ", evenCount=" + evenCount +
                '}';
    }
}
