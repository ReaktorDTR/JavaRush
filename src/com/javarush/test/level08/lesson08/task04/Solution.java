package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));
        map.put("Koko", new Date("JULY 21 1940"));
        map.put("Lolo", new Date("MARCH 8 2001"));
        map.put("Non", new Date("AUGUST 13 1977"));
        map.put("Triodin", new Date("MARCH 23 1989"));
        map.put("Tranduil", new Date("FEBRUARY 1 1990"));
        map.put("Nomeril", new Date("JANUARY 21 1960"));
        map.put("Zabuza", new Date("AUGUST 7 1995"));
        map.put("Naruto", new Date("MARCH 5 1967"));
        map.put("Shinji", new Date("MARCH 13 1991"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            Date date = pair.getValue();
            int month = date.getMonth();
            if (month == 5 || month == 6 || month == 7) {
                iterator.remove();
            }
        }

    }

    public static void main(String[] args) {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);
        for (Map.Entry<String, Date> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().toString());
        }
    }
}
