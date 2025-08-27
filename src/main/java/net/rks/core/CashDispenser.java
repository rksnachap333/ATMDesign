package net.rks.core;

import net.rks.model.ATM;

public interface CashDispenser {
    void setNextDispenser(CashDispenser next);
    boolean canDispense(ATM atm, int amount);
    void dispense(ATM atm, int amount);
}
