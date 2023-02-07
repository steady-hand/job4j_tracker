package ru.job4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Item {
    private int id;
    private String name;

    private LocalDateTime created;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    public LocalDateTime getCreated() {
        return created;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static void main(String[] args) {
        Item item1 = new Item();
        Item item2 = new Item("Антон Гастон");
        Item item3 = new Item("Антон Гастон", 123);
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Текущая дата: " + currentDateTime);
    }

}