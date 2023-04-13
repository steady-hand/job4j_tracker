package ru.job4j.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(s -> Stream.of(Value.values()).map(v -> new Card(s, v)))
                .forEach(System.out::println);
    }

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }
}