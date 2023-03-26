package ru.job4j.tracker;

import ru.job4j.Item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemSorter {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(new Item("Vlad"), new Item("Artem"), new Item("Bogdan"));
        Collections.sort(items, new ItemAscByName());
        System.out.println(items.toString());
        Collections.sort(items, new ItemDescByName());
        System.out.println(items.toString());
    }
}
