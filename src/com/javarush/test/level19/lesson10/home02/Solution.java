package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> peoples = new TreeMap<>();
        while (fileReader.ready()) {
            String[] pair = fileReader.readLine().split(" ");
            if (peoples.containsKey(pair[0])) {
                peoples.put(pair[0], peoples.get(pair[0]) + Double.parseDouble(pair[1]));
            } else {
                peoples.put(pair[0], Double.parseDouble(pair[1]));
            }
        }
        Double max = Double.MIN_VALUE;
        for (Map.Entry<String, Double> pair : peoples.entrySet()) {
            if (pair.getValue() > max) {
                max = pair.getValue();
            }
        }
        for (Map.Entry<String, Double> pair : peoples.entrySet()) {
            if (pair.getValue() == max) {
                System.out.println(pair.getKey());
            }
        }
        fileReader.close();
    }
}
