package org.design.behavioral.mediator;

import java.util.Date;

/**
 * 银行，审批贷款
 */
public class Mediator {
    public static void sendMessage(Trader trader, String msg) {
        System.out.println(new Date().toString() + "[" + trader.getName() + "] :" + msg);
    }

}
