package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter fileWriter = new FileWriter(reader.readLine());
        ArrayList<Integer> listFile = new ArrayList<>();
        while (fileReader.ready()) {
            listFile.add(fileReader.read());
        }
        for (int i = 1; i < listFile.size(); i += 2) {
            fileWriter.write((char) (int) listFile.get(i));
        }
        fileReader.close();
        fileWriter.close();
    }
}
