package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
    Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static void main(String[] args) {
        Long t0 = System.currentTimeMillis();
        int n = Integer.MAX_VALUE;
        int[] mas = getNumbers(n);
        Long t1 = System.currentTimeMillis();
  /*      for (int e : mas) {
            System.out.println(e);
        }*/
        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");

    }

    public static int[] getNumbers(int N) {

        int size = String.valueOf(N).length();
        System.out.println(N + " = " + size);
        size++;
        int[] result = null;
        long[][] exp = new long[10][size];
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < size; j++) {
                exp[i][j] = (long) Math.pow(i, j);
            }
        }

        return result;
    }
}
