package net.rks.state;

import lombok.AllArgsConstructor;
import net.rks.enums.ATMStatus;
import net.rks.model.Card;
import net.rks.service.ATMMachine;

@AllArgsConstructor
public class CardInsertedState implements ATMState{
    private final ATMMachine atmMachine;
    @Override
    public void insertCard(Card card) {
        System.out.println("Card already inserted..");
    }

    @Override
    public void enterPin(String pin) {
        if(atmMachine.getCurrentCard().getPin().equals(pin)){
            System.out.println("PIN Correct. Authenticated.");
            atmMachine.setState(new AuthenticatedState(atmMachine));
        } else{
            System.out.println("PIN InCorrect.");
            ejectCard();
        }
    }

    @Override
    public void selectOption(String option) {

    }

    @Override
    public void dispenseCash(int amount) {
        System.out.println("Select an option first.");
    }

    @Override
    public void ejectCard() {
        atmMachine.setCurrentCard(null);
        System.out.println("Card ejected.");
        atmMachine.setState(new IdleState(atmMachine));
    }

    @Override
    public ATMStatus getStatus() {
        return ATMStatus.CARD_INSERTED;
    }
}
