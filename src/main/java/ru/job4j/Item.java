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
        this.created = LocalDateTime.now();
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


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created.format(FORMATTER) +
                '}';
    }
}