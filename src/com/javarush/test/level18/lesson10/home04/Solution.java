package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();
        FileInputStream inputStream1 = new FileInputStream(firstFile);
        FileInputStream inputStream2 = new FileInputStream(secondFile);
        byte[] buffer1 = new byte[inputStream1.available()];
        byte[] buffer2 = new byte[inputStream2.available()];
        inputStream1.read(buffer1);
        inputStream2.read(buffer2);
        inputStream1.close();
        inputStream2.close();
        reader.close();
        FileOutputStream outputStream = new FileOutputStream(firstFile);
        byte[] result = new byte[buffer1.length + buffer2.length];
        System.arraycopy(buffer2, 0, result, 0, buffer2.length);
        System.arraycopy(buffer1, 0, result, buffer2.length, buffer1.length);
        outputStream.write(result);
        outputStream.close();
    }
}
