package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args[0].equals("-e")) {
            crypt(args[1], args[2]);
        } else if (args[0].equals("-d")) {
            decrypt(args[1], args[2]);
        }
    }

    public static void crypt(String fileNameIn, String fileNameOut) throws IOException {
        FileInputStream fileIn = new FileInputStream(fileNameIn);
        FileOutputStream fileOut = new FileOutputStream(fileNameOut);
        while (fileIn.available() > 0) {
            fileOut.write(fileIn.read() + 1);
        }
        fileIn.close();
        fileOut.close();
    }

    public static void decrypt(String fileNameIn, String fileNameOut) throws IOException {
        FileInputStream fileIn = new FileInputStream(fileNameIn);
        FileOutputStream fileOut = new FileOutputStream(fileNameOut);
        while (fileIn.available() > 0) {
            fileOut.write(fileIn.read() - 1);
        }
        fileIn.close();
        fileOut.close();
    }

}
