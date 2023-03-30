package ru.job4j.tracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.Item;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

class ItemSorterTest {
    @Test
    public void itemAscByName() {
        Item bogdan = new Item("bogdan");
        Item vlad = new Item("vlad");
        Item artem = new Item("artem");
        List<Item> items = Arrays.asList(bogdan, vlad, artem);
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(artem, bogdan, vlad);
        Assertions.assertArrayEquals(items.toArray(), expected.toArray());
    }

    @Test
    public void itemDescByName() {
        Item bogdan = new Item("bogdan");
        Item vlad = new Item("vlad");
        Item artem = new Item("artem");
        List<Item> items = Arrays.asList(bogdan, vlad, artem);
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(vlad, bogdan, artem);
        Assertions.assertArrayEquals(items.toArray(), expected.toArray());
    }
}