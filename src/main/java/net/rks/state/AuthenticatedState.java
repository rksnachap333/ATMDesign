package net.rks.state;

import lombok.AllArgsConstructor;
import net.rks.enums.ATMStatus;
import net.rks.model.Card;
import net.rks.service.ATMMachine;

@AllArgsConstructor
public class AuthenticatedState implements ATMState{
    private final ATMMachine atmMachine;

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
        //Can add options like deposit, check balance, withdrawal base on option selected will move
        // Right now we have only one withdrawal option

        System.out.println("Option selected : Withdrawal.");
        atmMachine.setState(new DispenseCashState(atmMachine));

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
        return ATMStatus.AUTHENTICATED;
    }
}
