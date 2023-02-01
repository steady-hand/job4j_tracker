package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza{
    private static final String name = " с супер крутым сыром";
    public String name() {
        return super.name() + name;
    }
}
