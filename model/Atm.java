import AtmState;

package model;
public class Atm {

    private String atmId;
    private String location;
    private int balance;
    private int twoThousandCount;
    private int fiveHundredCount;
    private int twoHundredCount;
    private AtmState status;

    public Atm(String atmId, String location, int balance, int twoThousandCount, int fiveHundredCount,
            int twoHundredCount, AtmState status) {
        this.atmId = atmId;
        this.location = location;
        this.balance = balance;
        this.twoThousandCount = twoThousandCount;
        this.fiveHundredCount = fiveHundredCount;
        this.twoHundredCount = twoHundredCount;
        this.status = status;
    }

    public String getAtmId() {
        return atmId;
    }

    public String getLocation() {
        return location;
    }

    public int getBalance() {
        return balance;
    }

    public int getTwoThousandCount() {
        return twoThousandCount;
    }

    public int getFiveHundredCount() {
        return fiveHundredCount;
    }

    public int getTwoHundredCount() {
        return twoHundredCount;
    }

    public AtmState getStatus() {
        return status;
    }

    public void setAtmId(String atmId) {
        this.atmId = atmId;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setTwoThousandCount(int twoThousandCount) {
        this.twoThousandCount = twoThousandCount;
    }

    public void setFiveHundredCount(int fiveHundredCount) {
        this.fiveHundredCount = fiveHundredCount;
    }

    public void setTwoHundredCount(int twoHundredCount) {
        this.twoHundredCount = twoHundredCount;
    }

    public void setStatus(AtmState status) {
        this.status = status;
    }

}
