import model.Card;

public interface States {

    void inserCard(Card card);

    void ejectCard();

    void selectOption(Operation operation);

    void enterPin(String pin);

    void requestCash(int amount);

}