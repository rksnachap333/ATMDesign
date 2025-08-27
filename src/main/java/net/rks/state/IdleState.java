package net.rks.state;

import lombok.AllArgsConstructor;
import net.rks.enums.ATMStatus;
import net.rks.model.Card;
import net.rks.service.ATMMachine;

@AllArgsConstructor
public class IdleState implements ATMState{
    private final ATMMachine atmMachine;

    @Override
    public void insertCard(Card card) {
        atmMachine.setCurrentCard(card);
        System.out.println("Card Inserted.");
        atmMachine.setState(new CardInsertedState(atmMachine));
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("No card inserted.");
    }

    @Override
    public void selectOption(String option) {
        System.out.println("No card inserted.");
    }

    @Override
    public void dispenseCash(int amount) {
        System.out.println("No card inserted.");
    }

    @Override
    public void ejectCard() {
        System.out.println("No card inserted.");
    }

    @Override
    public ATMStatus getStatus() {
        return ATMStatus.IDLE;
    }
}
