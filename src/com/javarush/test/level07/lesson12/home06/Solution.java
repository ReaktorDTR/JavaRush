package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution {
    public static void main(String[] args) {
        Human ded1 = new Human("Stepan", true, 70, null, null);
        Human ded2 = new Human("Vasil", true, 65, null, null);
        Human babka1 = new Human("Domka", false, 60, null, null);
        Human babka2 = new Human("Vasilina", false, 58, null, null);
        Human otec = new Human("Vasil", true, 50, ded2, babka2);
        Human mama = new Human("Mariya", false, 45, ded1, babka1);
        Human sun1 = new Human("Sergiy", true, 25, otec, mama);
        Human sun2 = new Human("Andriy", true, 18, otec, mama);
        Human docha = new Human("Lena", false, 17, otec, mama);
        ded1.show();
        ded2.show();
        babka1.show();
        babka2.show();
        otec.show();
        mama.show();
        sun1.show();
        sun2.show();
        docha.show();


    }

    public static class Human {
        public String name;
        public boolean sex;
        public int age;
        public Human father;
        public Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }

        public void show() {
            String out = toString();
            System.out.println(out);
        }

    }

}
