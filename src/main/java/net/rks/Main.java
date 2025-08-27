package net.rks;

import net.rks.model.ATM;
import net.rks.model.Account;
import net.rks.model.Card;
import net.rks.repository.ATMRepository;
import net.rks.service.ATMMachine;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("*****************Hello and welcome! to the ATM System**************");
        System.out.println("********************************************************************");

        Card card = new Card(
                "CARD1234",
                "1234",
                new Account("ACC1234", 5000)
        );
        ATM atm1 = new ATM("ATM1",5,5,20);
        ATM atm2 = new ATM("ATM2",0,2,5);

        ATMRepository atmRepository = new ATMRepository();
        atmRepository.save(atm1);
        atmRepository.save(atm2);

        ATMMachine atmMachine2 = new ATMMachine("ATM2", atmRepository);
        atmMachine2.insertCard(card);
        atmMachine2.enterPin("12345");
        atmMachine2.selectOption("WITHDRAWAL");
        atmMachine2.dispenseCash(1010);
    }
}