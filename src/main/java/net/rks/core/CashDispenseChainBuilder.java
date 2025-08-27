package net.rks.core;

public class CashDispenseChainBuilder {

    public static CashDispenser builderChain() {
        CashDispenser d1 = new TwoThousandDispenser();
        CashDispenser d2 = new FiveHundredDispenser();
        CashDispenser d3 = new OneHundredDispenser();
        d1.setNextDispenser(d2);
        d2.setNextDispenser(d3);
        return d1;
    }
}
