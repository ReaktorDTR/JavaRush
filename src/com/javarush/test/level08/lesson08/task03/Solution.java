package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Довганюк", "Сергій");
        map.put("Заліско", "Сергій");
        map.put("Граб", "Сергій");
        map.put("Каштав", "Оля");
        map.put("Каштан", "Юля");
        map.put("Бзовик", "Ірина");
        map.put("Шевчак", "Юлія");
        map.put("Шевчук", "Катерина");
        map.put("Курдило", "Сергій");
        map.put("Катан", "Людмила");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count = 0;
        for (Map.Entry<String,String> pair : map.entrySet()){
            String firstName = pair.getValue();
            if (firstName.equals(name)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()){
            String lastName = pair.getKey();
            if (lastName.equals(familiya)) count++;
        }
        return count;
    }

}
