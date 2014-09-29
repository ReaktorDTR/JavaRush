package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a[] = new int[4];
        for (int i = 0; i < 4; i++) {
            a[i] = Integer.parseInt(reader.readLine());
        }
        int max = a[0];
        for (int i = 0; i < 4; i++) {
            if (a[i] > max) max = a[i];
        }
        System.out.println(max);
    }
}
