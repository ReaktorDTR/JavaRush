package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();
        FileInputStream inputStream = new FileInputStream(firstFile);
        FileOutputStream outputStream = new FileOutputStream(secondFile);
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        inputStream.close();
        outputStream.write(output(buffer));
    }

    public static byte[] output(byte[] buffer) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] in = new String(buffer).split(" ");
        byte[] result;
        long[] temp = new long[in.length];
        for (int i = 0; i < in.length; i++) {
            temp[i] = Math.round(Double.valueOf(in[i]));
        }
        for (long i : temp) {
            stringBuilder.append(i);
            stringBuilder.append(" ");
        }
        result = stringBuilder.toString().getBytes();
        return result;
    }
}
