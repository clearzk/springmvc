package com.ai.mvc.interview.basic.pattern.prototype;

public class Client {
    public static void main(String[] args) {
        Manager manager=new Manager();
        Product messageBox=new MessageBox('*');
        Product underLinePen=new UnderLinePen('`');
        manager.register("MB",messageBox);
        manager.register("ULP",underLinePen);
        manager.create("MB");
        manager.create("ULP");
        messageBox.use("xiaoqiao");
        underLinePen.use("zhouyu");
    }
}
