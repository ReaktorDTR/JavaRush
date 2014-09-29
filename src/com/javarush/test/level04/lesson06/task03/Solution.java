package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a[] = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = Integer.parseInt(reader.readLine());
        }
        for (int j = 0; j < 2; j++)
            for (int i = 0; i < 2; i++) {
                if (a[i] < a[i+1])
                {
                    int buff=a[i];
                    a[i] = a[i+1];
                    a[i+1] = buff;
                }
            }
        for (int i = 0; i < 3 ; i++) {
            System.out.println(a[i]);
        }
    }
}
