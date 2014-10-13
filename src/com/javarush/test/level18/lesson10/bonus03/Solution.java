package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        comParser(filename, args);
    }

    public static void comParser(String fileName, String[] commands) throws IOException {
        ArrayList<Integer> allId = getAllId(fileName);
        ArrayList<String> allStrings = getAllStrings(fileName);

        if (commands[0].equals("-c")) {
            int currentID = getMaxIdFromFile(fileName);
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
            StringBuilder fullParam = new StringBuilder();
            fullParam.append(fullString(String.valueOf(++currentID), 8));
            fullParam.append(fullString(commands[1], 30));
            fullParam.append(fullString(commands[2], 8));
            fullParam.append(fullString(commands[3], 4));
            printWriter.println(fullParam);
            printWriter.close();
        } else if (commands[0].equals("-u")) {
            StringBuilder fullParam = new StringBuilder();
            fullParam.append(fullString(commands[1], 8));
            fullParam.append(fullString(commands[2], 30));
            fullParam.append(fullString(commands[3], 8));
            fullParam.append(fullString(commands[4], 4));

            if (allId.contains(Integer.parseInt(commands[1]))) {
                int index = allId.indexOf(Integer.parseInt(commands[1]));
                allStrings.set(index, fullParam.toString());
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
                for (String element : allStrings) {
                    printWriter.println(element);
                }
                printWriter.close();
            } else {
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
                printWriter.println(fullParam);
                printWriter.close();
            }
        } else if (commands[0].equals("-d")) {
            if (allId.contains(Integer.parseInt(commands[1]))) {
                int index = allId.indexOf(Integer.parseInt(commands[1]));
                allStrings.remove(index);
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
                for (String element : allStrings) {
                    printWriter.println(element);
                }
                printWriter.close();
            }
        }
    }

    public static String fullString(String inString, int count) {
        int lostSpaces = count - inString.length();
        String fullStr = inString;
        if (lostSpaces < count) {
            for (int i = 0; i < lostSpaces; i++) {
                fullStr += " ";
            }
        } else fullStr = inString.substring(0, count);
        return fullStr;
    }

    public static int getMaxIdFromFile(String fileName) throws IOException {
        return Collections.max(getAllId(fileName));
    }

    public static ArrayList<Integer> getAllId(String fileName) throws IOException {
        ArrayList<Integer> idList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String buffer;
        while ((buffer = reader.readLine()) != null) {
            idList.add(Integer.parseInt(buffer.substring(0, 8).replace(" ", "")));
        }
        reader.close();
        return idList;
    }

    public static ArrayList<String> getAllStrings(String fileName) throws IOException {
        ArrayList<String> listStrings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String buffer;
        while ((buffer = reader.readLine()) != null) {
            listStrings.add(buffer);
        }
        reader.close();
        return listStrings;
    }
}

