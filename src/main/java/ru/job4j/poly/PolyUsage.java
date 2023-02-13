package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle train = new Train();
        Vehicle electroBus = new ElectroBus();
        Vehicle airplane = new Airplane();
        Vehicle[] vehicles = new Vehicle[] {train, electroBus, airplane
        };
        for (Vehicle i : vehicles) {
            i.move();
        }
    }
}
