package com.javarush.test.level09.lesson11.home09;

import javax.lang.model.element.Element;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String, Cat> cat = new HashMap<String, Cat>();
        cat.put("kot1", new Cat("Kot1"));
        cat.put("kot2", new Cat("Kot2"));
        cat.put("kot3", new Cat("Kot3"));
        cat.put("kot4", new Cat("Kot4"));
        cat.put("kot5", new Cat("Kot5"));
        cat.put("kot6", new Cat("Kot6"));
        cat.put("kot7", new Cat("Kot7"));
        cat.put("kot8", new Cat("Kot8"));
        cat.put("kot9", new Cat("Kot9"));
        cat.put("kot10", new Cat("Kot10"));
        return cat;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> set = new HashSet<Cat>();
        for (Map.Entry<String, Cat> element : map.entrySet()) {
            set.add(element.getValue());
        }
        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
