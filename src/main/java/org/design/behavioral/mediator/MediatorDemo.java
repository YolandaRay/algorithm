package org.design.behavioral.mediator;
/*
中介者模式（Mediator Pattern）是用来降低多个对象和类之间的通信复杂性。这种模式提供了一个中介类，该类通常处理不同类之间的通信，并支持松耦合，使代码易于维护。中介者模式属于行为型模式。
 侧重系统内部组件相互调用
 */
public class MediatorDemo {
    public static void main(String[] args) {
        Trader seller = new Seller("Ray");
        Trader buyer = new Buyer("Tom");

        seller.tradeHouse("please pay money");
        buyer.tradeHouse("please check money");
    }
}
