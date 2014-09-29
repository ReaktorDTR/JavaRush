package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        public String name;
        public boolean sex;
        public int age;
        public String colorSkin;
        public boolean hair;
        public String colorHair;

        public Human(String name, boolean sex, int age, String colorSkin, boolean hair, String colorHair) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.colorSkin = colorSkin;
            this.hair = hair;
            this.colorHair = colorHair;
        }

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.colorSkin = "white";
            this.hair = true;
            this.colorHair = "black";
        }

        public Human(String name, boolean sex, int age, String colorSkin) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.colorSkin = colorSkin;
            this.hair = true;
            this.colorHair = "black";
        }

        public Human(String name, boolean sex, int age, String colorSkin, String colorHair) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.colorSkin = colorSkin;
            this.hair = true;
            this.colorHair = colorHair;
        }

        public Human(boolean sex, int age, String colorSkin, boolean hair, String colorHair) {
            this.name = "Unknown";
            this.sex = sex;
            this.age = age;
            this.colorSkin = colorSkin;
            this.hair = hair;
            this.colorHair = colorHair;
        }

        public Human(boolean sex, int age) {
            this.name = "Unknown";
            this.sex = sex;
            this.age = age;
            this.colorSkin = "white";
            this.hair = true;
            this.colorHair = "black";
        }

        public Human(boolean sex, int age, String colorSkin) {
            this.name = "Unknown";
            this.sex = sex;
            this.age = age;
            this.colorSkin = colorSkin;
            this.hair = true;
            this.colorHair = "black";
        }

        public Human(boolean sex, int age, String colorSkin, String colorHair) {
            this.name = "Unknown";
            this.sex = sex;
            this.age = age;
            this.colorSkin = colorSkin;
            this.hair = true;
            this.colorHair = colorHair;
        }

        public Human(String name, boolean sex, int age, boolean hair, String colorHair) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.colorSkin = "white";
            this.hair = hair;
            this.colorHair = colorHair;
        }

        public Human (Human in){
            this.name = in.name;
            this.sex = in.sex;
            this.age = in.age;
            this.colorSkin = in.colorSkin;
            this.hair = in.hair;
            this.colorHair = in.colorHair;
        }
    }
}
