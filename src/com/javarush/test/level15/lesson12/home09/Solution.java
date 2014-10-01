package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        ArrayList<String> listParam = new ArrayList<String>();
        listParam = parseString(url);
        listParamOut(listParam);
        parseParam(listParam);
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }

    public static ArrayList parseString(String url) {
        ArrayList<String> listParam = new ArrayList<String>();
        url = url.substring(url.indexOf("?") + 1);
        String[] arrayParam = url.split("&");
        for (String elementArrayParam : arrayParam) {
            String param;
            param = elementArrayParam.replaceAll("&", "").replace("?", "");
            if (!param.isEmpty()) listParam.add(param);
        }
        return listParam;
    }

    public static void listParamOut(ArrayList<String> listParam) {
        for (String element : listParam) {
            if (element.contains("=")) {
                System.out.print(element.substring(0, element.indexOf("=")) + " ");
            } else
                System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void parseParam(ArrayList<String> listParam) {
        for (String element : listParam) {
            String param = "";
            String value = "";
            if (element.contains("=")) {
                String[] pair = element.split("=");
                if (pair.length == 2) {
                    param = pair[0];
                    value = pair[1];
                }
            }

            if (param.equals("obj")) {
                try {
                    alert(Double.parseDouble(value));
                } catch (Exception e) {
                    alert(value);
                }
            }
        }
    }

}
