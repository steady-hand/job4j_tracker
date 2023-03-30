package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int m) {
        return m - x;
    }

    public int divide(int d) {
        return d / x;
    }

    public int sumAllOperations(int ss, Calculator calculator) {
        return Calculator.minus(ss) + Calculator.sum(ss) + calculator.multiply(ss) + calculator.divide(ss);
    }

    public static void main(String[] args) {
        int rsl0 = sum(10);
        System.out.println(rsl0);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        int rsl2 = minus(1);
        System.out.println(rsl2);
        int rsl3 = calculator.divide(1);
        System.out.println(rsl3);
        int rsl4 = calculator.sumAllOperations(1, calculator);
        System.out.println(rsl4);
    }
}
