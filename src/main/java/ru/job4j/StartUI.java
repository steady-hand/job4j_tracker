package ru.job4j;


import ru.job4j.tracker.*;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

        public void init(Input input, Tracker tracker, UserAction[] actions){
            boolean run = true;
            while (run) {
                showMenu();
                int select = input.askInt("Select: ");
                if (select < 0 || select >= actions.length) {
                    out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                    continue;
                }
                UserAction action = actions[select];
                run = action.execute(input, tracker);
            }
        }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ShowAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new FindIdAction(output),
                new FindNameAction(output),
                new ExitAction(),
        };
        new StartUI(output).init(input, tracker, actions);
    }
}