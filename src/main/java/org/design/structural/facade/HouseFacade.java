package org.design.structural.facade;


public class HouseFacade {
    private Government bank;
    private Government taxBureau;
    private Government houseManagement;

    public HouseFacade() {
        this.bank = new Bank();
        this.taxBureau = new TaxBureau();
        this.houseManagement = new HouseManagement();
    }

    public void approvingLoans() {
        bank.serveThePeople();
    }

    public void Acquisition() {
        houseManagement.serveThePeople();
    }

    public void payDeedTax() {
        taxBureau.serveThePeople();
    }
}
