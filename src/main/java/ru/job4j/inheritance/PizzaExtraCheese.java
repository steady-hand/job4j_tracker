package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    private static final String NAME = " с супер крутым сыром";

    public String name() {
        return super.name() + NAME;
    }
}
