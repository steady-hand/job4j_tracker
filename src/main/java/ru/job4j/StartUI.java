package ru.job4j;


import ru.job4j.tracker.*;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

        public void init(Input input, Tracker tracker, List<UserAction> actions){
            boolean run = true;
            while (run) {
                showMenu();
                int select = input.askInt("Select: ");
                if (select < 0 || select >= actions.size()) {
                    out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                    continue;
                }
                UserAction action = actions.get(select);
                run = action.execute(input, tracker);
            }
        }

    private void showMenu() {
        List<String> menu = List.of("1. Add new Item", "2. Show all items", "3. Edit item",
                "4. Delete item", "5. Find item by id", "6. Find items by name",
                "7. Exit Program");
        out.println("Menu:");
        for (String check : menu) {
            out.println(check);
        }
    }
//        List<String> menu = List.of("1. Add new Item \n2. Show all items \n3. Edit item \n4. Delete item \n5. Find item by id \n6. Find items by name \n7. Exit Program");
    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new CreateAction(output),
                new ShowAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new FindIdAction(output),
                new FindNameAction(output),
                new ExitAction());
        new StartUI(output).init(input, tracker, actions);
    }
}