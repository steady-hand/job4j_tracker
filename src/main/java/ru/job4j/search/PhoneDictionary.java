package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }
    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */

    public ArrayList<Person> find(String key) {
        Predicate<Person> findByPhone = (value) -> value.getPhone().contains(key);
        Predicate<Person> findByName = (value) -> value.getName().contains(key);
        Predicate<Person> findByAddress = (value) -> value.getAddress().contains(key);
        Predicate<Person> findBySurname = (value) -> value.getSurname().contains(key);
        Predicate<Person> combine = findByPhone.or(findByAddress.or(findByName.or(findBySurname)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person value : persons) {
            if (combine.test(value)) {
                result.add(value);
            }
        }
        return result;
    }
}
