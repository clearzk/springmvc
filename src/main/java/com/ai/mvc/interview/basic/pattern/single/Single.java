package com.ai.mvc.interview.basic.pattern.single;
/*
单例：
1，私有化构造方法
2，定义一个成员变量
3，对外提供一个获取实例的静态方法
 */
public class Single {

    private Single(){};

    //volatile 确保内存可见性，设置内存屏障防止指令重拍
    private volatile static Single instance=null;

    public static Single getInstance() {
        if (instance == null) {// ThreadA ThreadB
            synchronized(Single.class){
                if (instance == null) {
                    instance=new Single();
                }
            }
        }
        return instance;
    }

}
