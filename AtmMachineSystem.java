import model.Atm;
import model.Card;

public class AtmMachineSystem implements States {
    private Atm atm;
    private AtmState atmState;
    private AtmRepo atmRepo;
    private Card cuurentCard;
    public Operation currentOperation;

    public AtmMachineSystem(Atm atm, AtmRepo atmRepo) {
        this.atm = atm;
        this.atmRepo = atmRepo;
        this.atmState = AtmState.IDLE;
    }

    public Atm getAtm() {
        return atm;
    }

    public AtmState getAtmState() {
        return atmState;
    }

    public AtmRepo getAtmRepo() {
        return atmRepo;
    }

    public Card getCuurentCard() {
        return cuurentCard;
    }

    @Override
    public void inserCard(Card card) {
        this.cuurentCard = card;
        this.atmState = AtmState.CARD_INSERTED;
    }

    @Override
    public void ejectCard() {
        this.cuurentCard = null;
        this.atmState = AtmState.IDLE;
        this.currentOperation = null;
    }

    @Override
    public void selectOption(Operation operation) {
        this.currentOperation = operation;
    }

    @Override
    public void enterPin(String pin) {
        if (this.cuurentCard.getPin() == pin) {
            // Authentication successful
            this.atmState = AtmState.AUTHENTICATED;
        } else {
            // Authentication failed
            this.atmState = AtmState.IDLE;
            this.cuurentCard = null;
        }
    }

    @Override
    public void requestCash(int amount) {
        if (this.atmState == AtmState.AUTHENTICATED && this.currentOperation == Operation.WITHDRAW) {
            if (this.atm.getBalance() >= amount && this.cuurentCard.getAccount().getBalance() >= amount) {
                // Dispense cash
                this.atm.setBalance(this.atm.getBalance() - amount);
                this.cuurentCard.getAccount().setBalance(this.cuurentCard.getAccount().getBalance() - amount);
                this.atmState = AtmState.DISPENSING_CASH;
            } else {
                // Insufficient funds
                System.out.println("Insufficient funds in ATM or Account.");
            }
        } else {
            System.out.println("Invalid state or operation for cash withdrawal.");
        }
    }

}
