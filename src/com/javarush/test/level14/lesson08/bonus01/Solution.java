package com.javarush.test.level14.lesson08.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\2.txt"));
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int[] a = new int[2];
            a[3] = 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int[] a = new int[-2];
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            arrayList.get(2);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Object x[] = new String[3];
            x[0] = new Integer(0);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int a = Integer.parseInt("zc");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Object o = Integer.valueOf(1);
            String s = (String) o;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            List list = null;
            list.add(1);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            String szShortString = "123";
            char chr = szShortString.charAt(10);
        } catch (Exception e) {
            exceptions.add(e);
        }

    }
}
