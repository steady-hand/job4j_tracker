package ru.job4j.poly;

public class Bus implements Transport{

    @Override
    public void go() {
    }

    @Override
    public void passengers(int quantity) {
        System.out.println("Quanlity of passengers = " + quantity);
    }

    @Override
    public int price(int quantityFuel) {
        return quantityFuel * 40;
    }

    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.go();
        bus.passengers(50);
        System.out.println(bus.price(100) + " rubles");
    }
}
