package ru.job4j.pojo;

public class Book {
    private String name;
    private int amound;

    public Book(String name, int amound) {
        this.name = name;
        this.amound = amound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmound() {
        return amound;
    }

    public void setAmound(int amound) {
        this.amound = amound;
    }
}
