package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String word1 : origin) {
            check.add(word1);
        }
        for (String word2 : text) {
            if (!check.contains(word2)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
