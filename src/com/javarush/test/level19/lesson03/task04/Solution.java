package com.javarush.test.level19.lesson03.task04;

import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        PersonScannerAdapter adapter = new PersonScannerAdapter(new Scanner(new FileReader("c:/test.txt")));
        System.out.println(adapter.read());
    }

    public static class PersonScannerAdapter implements PersonScanner {
        Scanner scanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            Person person = null;
            if (scanner.hasNext()) {
                String[] input = scanner.nextLine().split(" ");
                Calendar calendar = new GregorianCalendar(Integer.parseInt(input[5]), Integer.parseInt(input[4]) - 1, Integer.parseInt(input[3]));
                person = new Person(input[1], input[2], input[0], calendar.getTime());
            }
            return person;
        }

        @Override
        public void close() throws IOException {
            this.scanner.close();
        }
    }
}
