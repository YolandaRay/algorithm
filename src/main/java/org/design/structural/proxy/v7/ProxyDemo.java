package org.design.structural.proxy.v7;

import java.util.Random;

/*
静态代理：
    在代理类中，被代理的对象类型改成被代理对象实现的接口类型；(代理的对象改成Movable类型)
    越来越像装饰者模式；
    设计模式即多态的简单运用；
 */
public class ProxyDemo {
    public static void main(String[] args) {
        Tank tank = new Tank();
        TimeProxy timeProxy = new TimeProxy(tank);
        LogProxy logProxy = new LogProxy(timeProxy);
        logProxy.move();
    }
}

interface Movable {
    void move();
}

class Tank implements Movable {
    /**
     * 模拟坦克移动了一段儿时间
     */
    @Override
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TimeProxy implements Movable {
    Movable m;

    public TimeProxy(Movable movable) {
        this.m = movable;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

class LogProxy implements Movable {
    Movable m;

    public LogProxy(Movable movable) {
        this.m = movable;
    }

    @Override
    public void move() {
        System.out.println("start moving...");
        m.move();
        long end = System.currentTimeMillis();
        System.out.println("stopped!");
    }
}

