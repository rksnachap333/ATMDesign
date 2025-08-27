package net.rks.repository;

import net.rks.enums.ATMStatus;
import net.rks.model.ATM;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ATMRepository {

    private final Map<String, ATM> atms = new HashMap<>();

    public void save(ATM atm) {
        atms.put(atm.getId(), atm);
    }

    public Optional<ATM> getById(String id) {
        return Optional.ofNullable(atms.get(id));
    }

    public void updateATMStatusById(String id, ATMStatus status) {
        atms.get(id).setStatus(status);
    }
}
