package com.ai.mvc.interview.basic.dynamic_proxy.jdk;

import java.io.Serializable;

public class User implements Serializable {

    private String name;

    private Integer age;

    private String addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }

    public User(String name, Integer age, String addr) {
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    public User() {

    }
}
