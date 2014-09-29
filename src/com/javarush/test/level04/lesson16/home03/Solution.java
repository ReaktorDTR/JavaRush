package com.javarush.test.level04.lesson16.home03;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        int summ=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number;
        do {
            number=Integer.parseInt(reader.readLine());
            summ+=number;
        }while (number!=-1);
        System.out.println(summ);
    }
}
