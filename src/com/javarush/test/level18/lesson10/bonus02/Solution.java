package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

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
        ArrayList<Integer> idList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String buffer;
        while ((buffer = reader.readLine()) != null) {
            idList.add(Integer.parseInt(buffer.substring(0, 8).replace(" ", "")));
        }
        reader.close();
        return Collections.max(idList);
    }
}
