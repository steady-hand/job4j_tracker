package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    private static final String NAME = " и супер томатом";

    public String name() {
        return super.name() + NAME;
    }
}
