package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        List<String> addresses = new ArrayList<String>();
        List<String> familiya = new ArrayList<String>();
        while (true) {
            String address = reader.readLine();
            if (address.isEmpty()) break;
            addresses.add(address);
            String family = reader.readLine();
            if (family.isEmpty()) break;
            familiya.add(family);
        }

        //read home number
        String address = reader.readLine();

        if (addresses.contains(address)) {
            int pos = addresses.indexOf(address);
            System.out.println(familiya.get(pos));
        }
    }
}
