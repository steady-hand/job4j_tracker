package ru.job4j.tracker;

import ru.job4j.Item;
import ru.job4j.Tracker;

public class FindNameAction implements UserAction{
    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявка с введенным name: " + name + " не найдена.");
        }
        return true;
    }
}
