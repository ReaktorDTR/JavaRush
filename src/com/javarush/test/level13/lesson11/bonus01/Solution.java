package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readfile = new BufferedReader(new FileReader(reader.readLine()));
        ArrayList<Integer> list = new ArrayList<Integer>();
        String data;
        while ((data = readfile.readLine()) != null) {
            int parInt = Integer.parseInt(data);
            if (parInt % 2 == 0) {
                list.add(parInt);
            }
        }
        Collections.sort(list);
        for (Integer element : list) {
            System.out.println(element);
        }
    }
}
