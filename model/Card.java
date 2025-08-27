package model;
public class Card {
    private String cardNumber;
    private String pin;
    private Account account;

    public Card(String cardNumber, String pin, Account account) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.account = account;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public Account getAccount() {
        return account;
    }

}
