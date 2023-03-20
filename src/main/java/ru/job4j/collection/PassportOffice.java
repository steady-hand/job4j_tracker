package ru.job4j.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl;
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            rsl = true;
        } else {
            System.out.println("Номер паспорта уже занят");
            rsl = false;
        }
        return rsl;
    }


    public Citizen get(String passport) {
        return citizens.get(passport);
    }
}