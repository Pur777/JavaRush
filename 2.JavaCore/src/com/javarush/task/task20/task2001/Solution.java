package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            String your_file_name = "C:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2001\\One.txt";
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ben");

            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();

            System.out.println(somePerson.name);
            for (Asset a : somePerson.assets) {
                System.out.println(a.getName());
                System.out.println(a.getPrice());
            }

        } catch (IOException e) {
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
                writer.println(name);
            for (Asset a : assets) {
                writer.println(a.getName());
                writer.println(a.getPrice());
            }
            writer.flush();
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            ArrayList<String> list = new ArrayList<>();
            name = reader.readLine();
            String s;
            while ((s = reader.readLine()) != null) {
                list.add(s);
            }

            for (int i = 0; i < list.size(); i = i + 2) {
                assets.add(new Asset(list.get(i), Double.parseDouble(list.get(i + 1))));
            }
        }
    }
}