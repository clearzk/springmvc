package com.ai.mvc.interview.basic.dynamic_proxy.jdk;

import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        User user=new User("zk",20,"芜湖");
        UserService service=new UserServiceImpl();
        MyHandler<UserService> handler=new MyHandler<>(service);
        UserService proxy = handler.getProxy();
        proxy.sayHi();
//        proxy.addUser(user);

    }
}
