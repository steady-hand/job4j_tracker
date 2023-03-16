package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("v.gabrusenok10@gmail.com", "Gabrusenok Vladislav Dmitrievich");
        map.put("v.gagaga@gmail.com", "Gabrusenok Artemi Dmitrievich");
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}

