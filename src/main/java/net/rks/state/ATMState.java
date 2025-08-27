package net.rks.state;

import net.rks.enums.ATMStatus;
import net.rks.model.Card;

public interface ATMState {

    void insertCard(Card card);

    void enterPin(String pin);

    void selectOption(String option);

    void dispenseCash(int amount);

    void ejectCard();

    ATMStatus getStatus();
}
