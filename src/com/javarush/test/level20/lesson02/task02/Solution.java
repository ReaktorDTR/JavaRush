package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//           File your_file_name = File.createTempFile("c:\\test.txt", null);
            OutputStream outputStream = new FileOutputStream("C:\\test.txt");
            InputStream inputStream = new FileInputStream("c:\\test.txt");

            JavaRush javaRush = new JavaRush();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date birthDate = new Date();
            User[] one = new User[3];

            one[0] = new User();
            one[0].setFirstName("Vasya");
            one[0].setLastName("Vasilev");
            one[0].setMale(true);
            birthDate = dateFormat.parse("15-01-1988");
            one[0].setBirthDate(birthDate);
            one[0].setCountry(User.Country.UKRAINE);

            one[1] = new User();
            one[1].setFirstName("Kolya");
            one[1].setLastName("Kolyanich");
            one[1].setMale(true);
            birthDate = dateFormat.parse("12-03-1977");
            one[1].setBirthDate(birthDate);
            one[1].setCountry(User.Country.RUSSIA);

            one[2] = new User();
            one[2].setFirstName("Sveta");
            one[2].setLastName("Svetilo");
            one[2].setMale(false);
            birthDate = dateFormat.parse("25-11-1990");
            one[2].setBirthDate(birthDate);
            one[2].setCountry(User.Country.OTHER);

            javaRush.users.add(one[0]);
            javaRush.users.add(one[1]);
            javaRush.users.add(one[2]);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

            if (javaRush.equals(loadedObject)) System.out.println("true");
            else System.out.println("false");


        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            for (User user : users) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                StringBuilder sb = new StringBuilder();
                System.out.println(user.getFirstName());
                System.out.println(user.getLastName());
                System.out.println(user.isMale());
                System.out.println(dateFormat.format(user.getBirthDate()));
                System.out.println(user.getCountry());

                sb.append(user.getFirstName() + " ");
                sb.append(user.getLastName() + " ");
                sb.append(user.isMale() + " ");
                sb.append(dateFormat.format(user.getBirthDate()) + " ");
                sb.append(user.getCountry());
                writer.println(sb.toString());
                writer.flush();
            }
            writer.println("EndBlockUsers");
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if (reader.ready()) {
                while (reader.ready()) {
                    String str = reader.readLine();
                    if (str.equals("EndBlockUsers")) break;
                    String[] param = str.split(" ");
                    User user = new User();
                    user.setFirstName(param[0]);
                    user.setLastName(param[1]);
                    user.setMale(Boolean.parseBoolean(param[2]));
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    Date birthDate = dateFormat.parse(param[3]);
                    user.setBirthDate(birthDate);
                    switch (param[4]) {
                        case "UKRAINE": {
                            user.setCountry(User.Country.UKRAINE);
                            break;
                        }
                        case "RUSSIA": {
                            user.setCountry(User.Country.RUSSIA);
                            break;
                        }
                        default: {
                            user.setCountry(User.Country.OTHER);
                        }
                    }
                    this.users.add(user);
                }
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof JavaRush)) return false;

            JavaRush javaRush = (JavaRush) o;

            if (users != null ? !users.equals(javaRush.users) : javaRush.users != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
