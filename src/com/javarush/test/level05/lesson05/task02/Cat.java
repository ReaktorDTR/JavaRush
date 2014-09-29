package com.javarush.test.level05.lesson05.task02;

/* Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Зависимость придумать самому. Метод должен определять, выиграли ли мы (this) бой или нет,
т.е. возвращать true, если выиграли и false - если нет.
Должно выполняться условие:
если cat1.fight(cat2) = true , то cat2.fight(cat1) = false
*/

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int cat1 = 0, cat2 = 0;
        if (this.age > 1 && anotherCat.age < 1) {
            cat1++;
        } else if (this.age > 1 && anotherCat.age > 10) {
            cat1++;
        } else if (anotherCat.age > 1 && this.age < 1) {
            cat2++;
        } else if (anotherCat.age > 1 && this.age > 10) {
            cat2++;
        }
        if (this.weight > 2 && anotherCat.weight > 10)
            cat1++;
        else if (anotherCat.weight > 2 && this.weight > 10)
            cat2++;
        if (this.strength > anotherCat.strength) cat1++;
        else cat2++;
        if (cat1 > cat2) return true;
        else return false;
    }
}
