package org.design.structural.facade;

/**
 * 银行，审批贷款
 */
public class Bank implements Government {
    @Override
    public void serveThePeople() {
        System.out.println("Approving loans 审批贷款");
    }
}
