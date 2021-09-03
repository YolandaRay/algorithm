package org.design.behavioral.mediator;

/**
 * 房管局，办理房产证
 */
public class Seller extends Trader {
    private String name;

    public Seller(String name) {
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
//        System.out.println("Receive Money");
        Mediator.sendMessage(this, "please pay money");
    }
}
