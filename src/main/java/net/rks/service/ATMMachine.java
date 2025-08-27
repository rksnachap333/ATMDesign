package net.rks.service;

import lombok.Getter;
import lombok.Setter;
import net.rks.enums.ATMStatus;
import net.rks.factory.ATMStateFactory;
import net.rks.model.ATM;
import net.rks.model.Card;
import net.rks.repository.ATMRepository;
import net.rks.state.ATMState;
import net.rks.state.IdleState;

@Getter
public class ATMMachine {

    private final ATM atm;
    @Setter private ATMState state;
    private final ATMRepository atmRepository;
    @Setter
    private Card currentCard;

    public ATMMachine(String atmId, ATMRepository atmRepository) {
        this.atmRepository = atmRepository;
        this.atm = atmRepository.getById(atmId).orElseThrow(() -> new RuntimeException("ATM NOT FOUND!!"));
       this.state = ATMStateFactory.getState(atm.getStatus(),this);
       this.atm.setCashAvailable(atm.getTwoThousandCount() * 2000 + atm.getFiveHundredCount() * 500 + atm.getOneHundredCount() * 100);
    }

    public void insertCard(Card card) {
        state.insertCard(card);
    }

    public void enterPin(String pin) {
        state.enterPin(pin);
    }

    public void selectOption(String option) {
        state.selectOption(option);
    }

    public void dispenseCash(int amount) {
        state.dispenseCash(amount);
    }

    public void ejectCard() {
        state.ejectCard();
    }

}
