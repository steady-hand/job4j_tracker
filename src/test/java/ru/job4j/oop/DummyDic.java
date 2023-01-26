package ru.job4j.oop;

public class DummyDic {
    String engToRus(String eng) {
        String translate = "Неизвестное слово" + eng;
        return translate;
    }

    public static void main(String[] args) {
        DummyDic example = new DummyDic();
        String result = example.engToRus(" ниче не понял");
        System.out.println(result);
    }
}
