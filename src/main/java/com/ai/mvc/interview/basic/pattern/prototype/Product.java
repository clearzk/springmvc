package com.ai.mvc.interview.basic.pattern.prototype;

public interface Product extends Cloneable {

    abstract void use(String s);

    abstract Product createClone();

}
