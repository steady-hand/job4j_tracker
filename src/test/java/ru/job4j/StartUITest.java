package ru.job4j;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;

import java.security.Key;
import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.Assert.assertNull;


public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new CreateAction(out),
                new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }


    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "New item name", "1"}
        );
        List<UserAction> actions = List.of(new ReplaceAction(out),
                new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }


    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("Deleted item"));

        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = List.of(new DeleteAction(out),
                new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }
    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu:" + System.lineSeparator()
                        + "1. Add new Item" + System.lineSeparator()
                        + "2. Show all items" + System.lineSeparator()
                        + "3. Edit item" + System.lineSeparator()
                        + "4. Delete item" + System.lineSeparator()
                        + "5. Find item by id" + System.lineSeparator()
                        + "6. Find items by name" + System.lineSeparator()
                        + "7. Exit Program" + System.lineSeparator()
        );
    }
    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = List.of(new ReplaceAction(out),
                new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Edit item" + ln
                        + "3. Delete item" + ln
                        + "4. Find item by id" + ln
                        + "5. Find items by name" + ln
                        + "6. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Edit item" + ln
                        + "3. Delete item" + ln
                        + "4. Find item by id" + ln
                        + "5. Find items by name" + ln
                        + "6. Exit Program" + ln
        );
    }
    @Test
    public void whenshowAllItems() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        List<UserAction> actions = List.of(new ShowAction(out),
                new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Edit item" + ln
                        + "3. Delete item" + ln
                        + "4. Find item by id" + ln
                        + "5. Find items by name" + ln
                        + "6. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + "Хранилище еще не содержит заявок" + ln
                        + "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Edit item" + ln
                        + "3. Delete item" + ln
                        + "4. Find item by id" + ln
                        + "5. Find items by name" + ln
                        + "6. Exit Program" + ln
        );
    }
    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", "Vot", "1"}
        );
        List<UserAction> actions = List.of(new FindNameAction(out),
                new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Edit item" + ln
                        + "3. Delete item" + ln
                        + "4. Find item by id" + ln
                        + "5. Find items by name" + ln
                        + "6. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + "Заявка с введенным name: Vot не найдена." + ln
                        + "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Edit item" + ln
                        + "3. Delete item" + ln
                        + "4. Find item by id" + ln
                        + "5. Find items by name" + ln
                        + "6. Exit Program" + ln
        );
    }
    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        List<UserAction> actions = List.of(new FindIdAction(out),
                new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Edit item" + ln
                        + "3. Delete item" + ln
                        + "4. Find item by id" + ln
                        + "5. Find items by name" + ln
                        + "6. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + "Заявка с введенным id: 1 не найдена." + ln
                        + "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Edit item" + ln
                        + "3. Delete item" + ln
                        + "4. Find item by id" + ln
                        + "5. Find items by name" + ln
                        + "6. Exit Program" + ln
        );
    }
    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"7", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Edit item" + ln
                        + "3. Delete item" + ln
                        + "4. Find item by id" + ln
                        + "5. Find items by name" + ln
                        + "6. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Edit item" + ln
                        + "3. Delete item" + ln
                        + "4. Find item by id" + ln
                        + "5. Find items by name" + ln
                        + "6. Exit Program" + ln
        );
    }
}