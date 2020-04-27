package com.ai.mvc.interview.basic;

public class StringDemo {

    public static void main(String[] args) {
        String str1="ab";
        System.out.println(str1.intern() == str1);
        String str2="ab";
        System.out.println(str1 == str2);
    }
}
