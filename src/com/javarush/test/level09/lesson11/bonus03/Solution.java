package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        ArrayList<Integer> posNumber = new ArrayList<Integer>();
        ArrayList<Integer> posWord = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                posNumber.add(i);
            } else posWord.add(i);
        }
        //sort masiva chisel
        for (int i = 0; i < posNumber.size() - 1; i++) {
            for (int j = 0; j < posNumber.size() - i - 1; j++) {
                if (Integer.parseInt(array[posNumber.get(j)]) < Integer.parseInt(array[posNumber.get(j + 1)])) {
                    String buff = array[posNumber.get(j)];
                    array[posNumber.get(j)] = array[posNumber.get(j + 1)];
                    array[posNumber.get(j + 1)] = buff;
                }
            }
        }
        // sort masiva strok
        for (int i = 0; i < posWord.size() - 1; i++) {
            for (int j = 0; j < posWord.size() - i - 1; j++) {
                if (isGreaterThen(array[posWord.get(j)], array[posWord.get(j + 1)])) {
                    String buff = array[posWord.get(j)];
                    array[posWord.get(j)] = array[posWord.get(j + 1)];
                    array[posWord.get(j + 1)] = buff;
                }
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b) {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c) && c != '-') return false;
        }
        return true;
    }
}
