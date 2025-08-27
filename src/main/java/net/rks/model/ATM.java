package net.rks.model;

import lombok.Getter;
import lombok.Setter;
import net.rks.enums.ATMStatus;

@Getter
public class ATM {

    private final String id;
    @Setter private ATMStatus status;
    @Setter private double cashAvailable;
    @Setter private int twoThousandCount;
    @Setter private int fiveHundredCount;
    @Setter private int oneHundredCount;

    public ATM(String id, int twoThousandCount, int fiveHundredCount, int oneHundredCount) {
        this.id = id;
        this.twoThousandCount = twoThousandCount;
        this.fiveHundredCount = fiveHundredCount;
        this.oneHundredCount = oneHundredCount;
    }
}
