package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public Solution() {
    }

    public Solution(int pub2) {
    }

    public Solution(Double pub3) {
    }

    protected Solution(double pro1) {
    }

    protected Solution(String pro2) {
    }

    protected Solution(char pro3) {
    }

    private Solution(Number pri1) {
    }

    private Solution(Short pri2) {
    }

    private Solution(short pri3) {
    }

    Solution(Byte pp1) {
    }

    Solution(byte pp2) {
    }

    Solution(long pp3) {
    }
}

