package com.ai.mvc.interview.basic.dynamic_proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyHandler<T> implements InvocationHandler {

    private T target;

    public MyHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("----动态代理前置处理----");
        Object obj= method.invoke(target,args);
        System.out.println("----动态代理后置处理----");
        return obj;
    }

    public T getProxy() {
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }
}
