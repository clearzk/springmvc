package com.ai.mvc.interview.basic.pattern.prototype;

public class UnderLinePen implements Product {
    private char decochar;

    public UnderLinePen(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {
        int length = s.length();
        System.out.println("\"" + s + "\"");
        System.out.print(" ");
        for (int i = 0; i < length; i++) {
            System.out.print(decochar);
        }
        System.out.println("");
    }

    @Override
    public Product createClone() {
        Product p=null;
        try {
            p=(Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
