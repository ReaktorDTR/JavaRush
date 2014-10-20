package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        ArrayList<Integer> intList = new ArrayList<>();
        while (fileReader.ready()) {
            String[] words = fileReader.readLine().split(" ");
            for (String element : words) {
                try {
                    intList.add(Integer.parseInt(element));
                } catch (Exception e) {
                }
            }
        }
        for (Integer element : intList) {
            fileWriter.write(String.valueOf(element) + " ");
        }
        fileReader.close();
        fileWriter.close();
    }
}
