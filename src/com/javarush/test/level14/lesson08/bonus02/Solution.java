package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        if (a < b) {
            int buff = a;
            a = b;
            b = buff;
        }
        ArrayList<Integer> r = new ArrayList<Integer>();
        r.add(a);
        r.add(b);
        while (r.get(r.size() - 1) != 0) {
            int r1 = r.get(r.size() - 2);
            int r2 = r.get(r.size() - 1);
            r.add(r1 - (r2 * (r1 / r2)));
        }
        System.out.println(r.get(r.size() - 2));
    }
}
