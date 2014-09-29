package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("JANUARY 2 2000"));
    }

    public static boolean isDateOdd(String date) {
        Date d = new Date(date);
        Date d2 = new Date(d.getYear(), 0, 1);
        long kms = d.getTime() - d2.getTime();
        kms = kms / 1000 / 60 / 60 / 24 + 1;

        return kms % 2 == 0 ? false : true;
    }
}
