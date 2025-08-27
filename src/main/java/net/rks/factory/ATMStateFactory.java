package net.rks.factory;

import net.rks.core.CashDispenser;
import net.rks.enums.ATMStatus;
import net.rks.service.ATMMachine;
import net.rks.state.*;

public class ATMStateFactory {

    public static ATMState getState(ATMStatus status, ATMMachine atmMachine) {
        if(status == null) {
            atmMachine.setState(new IdleState(atmMachine));
        } else {
            if (status.equals(ATMStatus.AUTHENTICATED)) {
                atmMachine.setState(new AuthenticatedState(atmMachine));
            } else if (status.equals(ATMStatus.CARD_INSERTED)) {
                atmMachine.setState(new CardInsertedState(atmMachine));
            } else if (status.equals(ATMStatus.DISPENSE_CASH)) {
                atmMachine.setState(new DispenseCashState(atmMachine));
            } else {
                atmMachine.setState(new IdleState(atmMachine));
            }
        }
        return atmMachine.getState();
    }
}
