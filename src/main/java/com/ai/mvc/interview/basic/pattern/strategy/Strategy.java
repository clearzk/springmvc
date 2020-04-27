package com.ai.mvc.interview.basic.pattern.strategy;

public interface Strategy {
    abstract Hand nextHand();
    abstract void study(boolean win);
}
