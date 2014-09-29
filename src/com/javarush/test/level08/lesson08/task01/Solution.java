package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution {
    public static HashSet<String> createSet() {
        HashSet<String> set = new HashSet<String>();
        set.add("Люк");
        set.add("Лок");
        set.add("Ллк");
        set.add("Лйк");
        set.add("Лцывак");

        set.add("Лывфак");
        set.add("Лфыва");
        set.add("Лыва");
        set.add("Лфывак");
        set.add("Луцук");

        set.add("Луцуйк");
        set.add("Лпроук");
        set.add("Лумавк");
        set.add("Лукеук");
        set.add("Луиапык");

        set.add("Луыфвак");
        set.add("Лмавук");
        set.add("Луукцек");
        set.add("Луипак");
        set.add("Лувыфак");


        return set;
    }
}
