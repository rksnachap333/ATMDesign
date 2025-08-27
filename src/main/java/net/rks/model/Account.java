package net.rks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
public class Account {
    private final String accountNumber;
    @Setter private double balance;

}
