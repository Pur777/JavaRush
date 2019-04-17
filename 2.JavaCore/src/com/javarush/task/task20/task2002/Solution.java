package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            String yourFile = "C:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2002\\One.txt";
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            javaRush.users.add(new User());

            User user1 = new User();
            user1.setFirstName("Борис");
            user1.setLastName("Хуй попадешь");
            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
            Date date;
            date = format.parse("12 03 1988");
            user1.setBirthDate(date);
            javaRush.users.add(user1);
            user1.setMale(true);
            user1.setCountry(User.Country.OTHER);
            javaRush.users.add(new User());
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            for (User u : loadedObject.users) {
                System.out.println(u.getFirstName());
                System.out.println(u.getLastName());
                System.out.println(u.getBirthDate());
                System.out.println(u.isMale());
                System.out.println(u.getCountry());
            }
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            for (User u : users) {
                writer.println(u.getFirstName());

                writer.println(u.getLastName());

                if (u.getBirthDate() != null) {
                    Date dateNow = u.getBirthDate();
                    SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd MM yyyy HH:mm:ss S");
                    String z = formatForDateNow.format(dateNow);
                    writer.println(z);
                } else {
                    writer.println(u.getBirthDate());
                }
                writer.println(u.isMale());
                if (u.getCountry() == null) {
                    writer.println("null");
                }
                else if (u.getCountry().equals(User.Country.RUSSIA)) {
                    writer.println("Russia");
                } else  if (u.getCountry().equals(User.Country.UKRAINE)) {
                    writer.println("Ukraine");
                } else
                    writer.println("Other");
            }
            writer.flush();
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String s;
            ArrayList<String> list = new ArrayList<>();
            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy HH:mm:ss S");
            while ((s = reader.readLine()) != null) {
                list.add(s);
            }
            for (int i = 0; i < list.size(); i = i + 5) {
                User user = new User();
                user.setFirstName(list.get(i));

                user.setLastName(list.get(i + 1));

                if (list.get(i + 2).equals("null")) {
                    user.setBirthDate(null);
                } else {
                    Date date = format.parse(list.get(i + 2));
                    user.setBirthDate(date);
                }
                user.setMale(Boolean.parseBoolean(list.get(i + 3)));
                if (list.get(i + 4).equals("Ukraine")) {
                    user.setCountry(User.Country.UKRAINE);
                }
                else if (list.get(i + 4).equals("Russia")) {
                    user.setCountry(User.Country.RUSSIA);
                }
                else if (list.get(i + 4).equals("Other")) {
                    user.setCountry(User.Country.OTHER);
                }
                users.add(user);
            }
            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}