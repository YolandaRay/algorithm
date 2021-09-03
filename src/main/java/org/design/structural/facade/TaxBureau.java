package org.design.structural.facade;

/**
 * 税务局，交纳契税、个税
 */
public class TaxBureau implements Government {
    @Override
    public void serveThePeople() {
        System.out.println("Pay the deed tax 交契税");
    }
}
