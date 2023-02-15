package ru.job4j.tracker;

import ru.job4j.Tracker;

public class ExitAction implements UserAction{
    @Override
    public String name() {
        return "Exiting the application";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
