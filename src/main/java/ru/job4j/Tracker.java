package ru.job4j;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;


    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (index != -1) {
            int length = size - index - 1;
            System.arraycopy(items, index, items, index, length);
            items[size - 1] = null;
            size--;
            rsl = true;
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
            if (index != -1) {
                item.setId(id);
                items[index] = item;
                rsl = true;
            }
            return rsl;
        }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        Item[] notNull = new Item[items.length];
        int size = 0;
        for (int i = 0; i < this.size; i++) {
            Item item = items[i];
                notNull[size] = items[i];
                size++;
        }
        notNull = Arrays.copyOf(notNull, size);
        return notNull;
    }

    public Item[] findByName(String key) {
        Item[] name = new Item[items.length];
        int size = 0;
        for (int i = 0; i < this.size; i++) {
            Item item = items[i];
            if (item.getName() == key) {
                name[size] = items[i];
                size++;
            }
        }
        name = Arrays.copyOf(name, size);
        return name;
    }
}