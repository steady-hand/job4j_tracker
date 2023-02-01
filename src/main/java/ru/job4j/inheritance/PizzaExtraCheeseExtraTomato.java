package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese{
    private static final String name = " и супер томатом";
    public String name() {
        return super.name() + name;
    }
}
