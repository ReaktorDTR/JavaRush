package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        TreeMap<Character, Integer> treeMap = new TreeMap<Character, Integer>();
        byte[] data = new byte[inputStream.available()];
        inputStream.read(data);
        char[] chars = new String(data).toCharArray();
        for (char element : chars) {
            if (treeMap.containsKey(element)) {
                treeMap.put(element, treeMap.get(element) + 1);
            } else {
                treeMap.put(element, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
