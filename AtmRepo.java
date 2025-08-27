import java.util.*;

import model.Atm;

public class AtmRepo {

    private Map<String, Atm> atmMap = new HashMap<>();

    public void addAtm(Atm atm) {
        atmMap.put(atm.getAtmId(), atm);
    }

    public Atm getAtmById(String atmId) {
        return atmMap.get(atmId);
    }

    public List<Atm> getAllAtms() {
        return new ArrayList<>(atmMap.values());
    }

}