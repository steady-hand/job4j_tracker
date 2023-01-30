package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Первый параметр: " + active);
        System.out.println("Второй параметр: " + status);
        System.out.println("Третий параметр: " + message);
    }
    public Error() {
    }

    Error haha = new Error() {
    };

    public void lolKek() {
        System.out.println("Лол кек чебурек");
    }

    public static void main(String[] args) {
        Error error = new Error(true, 777, "Привет");
        Error haha = new Error();
        error.printInfo();
        haha.lolKek();
    }
}
