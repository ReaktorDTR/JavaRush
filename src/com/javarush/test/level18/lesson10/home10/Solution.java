package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> listFiles = new ArrayList<>();
        while (true) {
            String filename = reader.readLine();
            if (filename.equals("end")) {
                reader.close();
                break;
            }
            listFiles.add(filename);
        }
        Collections.sort(listFiles);
        String filePath = listFiles.get(0).substring(0, listFiles.get(0).indexOf(".part"));
        FileOutputStream outputStream = new FileOutputStream(filePath);
        for (String element : listFiles) {
            FileInputStream inputStream = new FileInputStream(element);
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            outputStream.write(data);
        }
        outputStream.close();
    }

}
