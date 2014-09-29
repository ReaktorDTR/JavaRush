package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        Human sun1 = new Human("Sergey", true, 25, new ArrayList<Human>());
        Human sun2 = new Human("Maks", true, 20, new ArrayList<Human>());
        Human docha = new Human("Lena", false, 18, new ArrayList<Human>());
        ArrayList<Human> buff1 = new ArrayList<Human>();
        buff1.add(sun1);
        buff1.add(sun2);
        buff1.add(docha);
        Human mama = new Human("Mariya", false, 45, buff1);
        Human batya = new Human("Vasya", true, 50, buff1);
        ArrayList<Human> buff2 = new ArrayList<Human>();
        buff2.add(batya);
        Human ded1 = new Human("Vasil", true, 70, buff2);
        Human bab1 = new Human("Vasilina", false, 67, buff2);
        ArrayList<Human> buff3 = new ArrayList<Human>();
        buff3.add(mama);
        Human ded2 = new Human("Stepan", true, 72, buff3);
        Human bab2 = new Human("Domka", false, 70, buff3);
        System.out.println(ded1);
        System.out.println(bab1);
        System.out.println(ded2);
        System.out.println(bab2);
        System.out.println(batya);
        System.out.println(mama);
        System.out.println(sun1);
        System.out.println(sun2);
        System.out.println(docha);
    }

    public static class Human {
        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }

            return text;
        }
    }

}
