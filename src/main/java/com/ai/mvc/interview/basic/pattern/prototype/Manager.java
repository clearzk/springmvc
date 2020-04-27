package com.ai.mvc.interview.basic.pattern.prototype;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<String,Object> showcase=new HashMap<>();

    public void register(String name,Product product) {
        showcase.put(name,product);
    }

    public Product create(String protoName) {
        Product product = (Product) showcase.get(protoName);
        return product.createClone();
    }
}
