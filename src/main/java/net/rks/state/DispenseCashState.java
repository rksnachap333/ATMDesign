package net.rks.state;

import lombok.AllArgsConstructor;
import net.rks.core.CashDispenseChainBuilder;
import net.rks.core.CashDispenser;
import net.rks.enums.ATMStatus;
import net.rks.model.Card;
import net.rks.service.ATMMachine;

@AllArgsConstructor
public class DispenseCashState implements ATMState {
    private final ATMMachine atmMachine;
    private final CashDispenser chain = CashDispenseChainBuilder.builderChain();

    @Override
    public void insertCard(Card card) {
        System.out.println("Card already inserted..");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("Authentication already done..");
    }

    @Override
    public void selectOption(String option) {
        System.out.println("Option already selected");
    }

    @Override
    public void dispenseCash(int amount) {
        double atmBalance = atmMachine.getAtm().getCashAvailable();
        double accountBalance = atmMachine.getCurrentCard().getAccount().getBalance();
        if (amount > atmBalance) {
            System.out.println("ATM has insufficient cash. Cannot dispense " + amount);
            ejectCard();
            return;
        }
        if (amount > accountBalance) {
            System.out.println("Insufficient account balance. Cannot dispense " + amount);
            ejectCard();
            return;
        }


        if (chain.canDispense(atmMachine.getAtm(), amount)) {
            chain.dispense(atmMachine.getAtm(), amount);

            // Deduct from ATM and account
            atmMachine.getAtm().setCashAvailable(atmBalance - amount);
            atmMachine.getCurrentCard().getAccount().setBalance(accountBalance - amount);

            // set the new state of ATM
            atmMachine.setState(new IdleState(atmMachine));
            System.out.println("Cash dispensed: "+amount);
        } else {
            System.out.println("Cannot dispense requested amount with available denominations.");
            ejectCard();
        }
    }

    @Override
    public void ejectCard() {
        atmMachine.setCurrentCard(null);
        System.out.println("Card ejected.");
        atmMachine.setState(new IdleState(atmMachine));
    }

    @Override
    public ATMStatus getStatus() {
        return ATMStatus.DISPENSE_CASH;
    }
}
