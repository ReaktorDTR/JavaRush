package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        try {
            while (!(fileName = rdr.readLine()).equals("exit")) {
                Thread readThread = new ReadThread(fileName);
                readThread.start();
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        } finally {
            try {
                rdr.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        String fileName;
        int temp, maxByte = 0;
        FileInputStream inputStream = null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        @Override
        public synchronized void run() {
            try {
                inputStream = new FileInputStream(fileName);
                while (inputStream.available() > 0) {
                    temp = inputStream.read();
                    if (map.containsKey(temp)) {
                        map.put(temp, map.get(temp) + 1);
                        maxByte = temp;
                    } else map.put(temp, 0);
                }
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (map.get(maxByte) < entry.getValue()) maxByte = entry.getKey();
                }
                resultMap.put(fileName, maxByte);
            } catch (FileNotFoundException e2) {
                System.out.println("File not found!");
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                try {
                    if (inputStream != null) inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}