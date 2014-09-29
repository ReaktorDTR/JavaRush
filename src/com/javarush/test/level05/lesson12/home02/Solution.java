package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution {
    public static void main(String[] args) {
        Man man1 = new Man("vashy", 20, "lololo");
        Man man2 = new Man("kolya", 25, "trolololo");
        Woman woman1 = new Woman("dasha", 25, "nonono");
        Woman woman2 = new Woman("nadya", 26, "yesyes");
        man1.print(man1);
        man2.print(man2);
        woman1.print(woman1);
        woman2.print(woman2);

    }

    public static class Man {
        public String name;
        public int age;
        public String address;

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public static void print(Man man) {
            System.out.println(man.name + " " + man.age + " " + man.address);
        }
    }

    public static class Woman {
        public String name;
        public int age;
        public String address;

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public static void print(Woman woman) {
            System.out.println(woman.name + " " + woman.age + " " + woman.address);
        }
    }
}
