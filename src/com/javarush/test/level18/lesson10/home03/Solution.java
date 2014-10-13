package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
        FileInputStream inputStream1 = new FileInputStream(reader.readLine());
        FileInputStream inputStream2 = new FileInputStream(reader.readLine());
        byte[] buffer = new byte[inputStream1.available()];
        int count = inputStream1.read(buffer);
        outputStream.write(buffer, 0, count);
        buffer = new byte[inputStream2.available()];
        count = inputStream2.read(buffer);
        outputStream.write(buffer, 0, count);
    }
}
