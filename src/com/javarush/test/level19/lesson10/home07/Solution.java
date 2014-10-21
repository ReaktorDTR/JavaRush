package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        List<String> longWords = new ArrayList<>();
        while (fileReader.ready()) {
            String[] words = fileReader.readLine().split(" ");
            for (String word : words) {
                if (word.length() > 6) longWords.add(word);
            }
        }
        fileReader.close();
        for (int i = 0; i < longWords.size(); i++) {
            if (i < longWords.size() - 1) {
                fileWriter.write(longWords.get(i) + ",");
            } else {
                fileWriter.write(longWords.get(i));
            }
        }
        fileWriter.close();
    }
}
