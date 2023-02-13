package ru.job4j.poly;

public class ElectroBus implements Vehicle{
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " просто едет по земле");
    }
}
