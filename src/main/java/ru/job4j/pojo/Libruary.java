package ru.job4j.pojo;

public class Libruary {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 100);
        Book book2 = new Book("Book2", 77);
        Book book3 = new Book("Book3", 987);
        Book book4 = new Book("Book4", 900);
        Book[] array = new Book[4];
        array[0] = book1;
        array[1] = book2;
        array[2] = book3;
        array[3] = book4;
        for (Book rsl : array) {
            System.out.println(rsl.getName() + " - " + rsl.getAmound());
        }
        Book local = array[0];
        array[0] = array[3];
        array[3] = local;
        for (Book rsl : array) {
            System.out.println(rsl.getName() + " - " + rsl.getAmound());
        }
        for (Book rsl : array) {
            if (rsl.getName().equals("Clean code")) {
                System.out.println(rsl.getName() + " - " + rsl.getAmound());
            }
        }
    }
}
