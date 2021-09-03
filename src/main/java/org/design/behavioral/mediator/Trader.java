package org.design.behavioral.mediator;

/**
 * 房产交易者
 */
public abstract class Trader {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    abstract void tradeHouse(String str);
}
