package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        List<String> fileOne = readFromFile("c:\\test.txt");
        List<String> fileTwo = readFromFile("c:\\test2.txt");
        for (int i = 0; i < fileOne.size(); i++) {

        }

//        for (String element : fileOne) {
//            if (fileTwo.contains(element)) {
//                lines.add(new LineItem(Type.SAME, element));
//            } else if (!fileTwo.contains(element)) {
//                lines.add(new LineItem(Type.REMOVED, element));
//            }
//        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }

    public static List<String> readFromFile(String filename) throws IOException {
        List<String> strings = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(filename));
        while (fileReader.ready()) {
            strings.add(fileReader.readLine());
        }
        fileReader.close();
        return strings;
    }
}
