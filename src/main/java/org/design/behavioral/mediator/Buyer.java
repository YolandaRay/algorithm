package org.design.behavioral.mediator;

/**
 * 买家
 */
public class Buyer extends Trader {
    private String name;

    public Buyer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void tradeHouse(String str) {
//        System.out.println("Pay money！");
        Mediator.sendMessage(this,"please check money");
    }
}
