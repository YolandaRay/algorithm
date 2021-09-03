package org.design.behavioral.observer.v9;

import java.util.ArrayList;
import java.util.List;

/*
认识javascript event对象
在很多系统中，Observer模式往往和责任链共同负责对于事件的处理，其中的某一个observer负责是否将事件进一步传递。
Observer、Listener、Hook、Callback其实用的都是观察者模式。之所以叫hook、callback是因为可以把函数（方法）当作参数传递。

有很多时候，观察者需要根据事件的具体情况来进行处理；
大多数时候，我们处理事件的时候，需要事件源对象。观察者和事件源也是解耦的。
事件也可以形成继承体系
 */

public class ChildDemo {
    public static void main(String[] args) {
        Child c = new Child();
        c.wakeUp();
    }

}

class Child {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<Observer>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
        observers.add((e) -> {
            System.out.println("hahaha.....");
        });
    }

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        WakeUpEvent wakeUpEvent = new WakeUpEvent(System.currentTimeMillis(), "Bed", this);
        for (Observer o : observers) {
            o.actionOnWakeUp(wakeUpEvent);
        }
    }
}

abstract class Event<T> {
    abstract T getSource();
}

class WakeUpEvent extends Event<Child> {
    long timestamp;
    String location;
    Child source;

    public WakeUpEvent(long timestamp, String location, Child source) {
        this.timestamp = timestamp;
        this.location = location;
        this.source = source;
    }

    @Override
    Child getSource() {
        return source;
    }
}

interface Observer {
    void actionOnWakeUp(WakeUpEvent wakeUpEvent);
}

class Dad implements Observer {

    @Override
    public void actionOnWakeUp(WakeUpEvent wakeUpEvent) {
        feed();
    }

    private void feed() {
        System.out.println("Dad feeding...");
    }
}

class Dog implements Observer {

    @Override
    public void actionOnWakeUp(WakeUpEvent wakeUpEvent) {
        feed();
    }

    private void feed() {
        System.out.println("Dog wang...");
    }
}

class Mum implements Observer {

    @Override
    public void actionOnWakeUp(WakeUpEvent wakeUpEvent) {
        feed();
    }

    private void feed() {
        System.out.println("Mum hugging...");
    }
}
