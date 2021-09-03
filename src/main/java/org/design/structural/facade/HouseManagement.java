package org.design.structural.facade;

/**
 * 房管局，办理房产证
 */
public class HouseManagement implements Government {
    @Override
    public void serveThePeople() {
        System.out.println("Acquisition of the Property Ownership Certificate 办房产证");
    }
}
