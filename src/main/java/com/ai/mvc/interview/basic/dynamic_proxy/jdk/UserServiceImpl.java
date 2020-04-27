package com.ai.mvc.interview.basic.dynamic_proxy.jdk;

public class UserServiceImpl implements UserService {

    @Override
    public void addUser(User user) {
        System.out.println(user);
    }

    @Override
    public void sayHi() {
        System.out.println("Hi,boy");
    }

}
