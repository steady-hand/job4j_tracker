package ru.job4j.poly;

public interface Transport {
    void go();
    void passengers (int quantity);
    int price (int quantityFuel);
}
