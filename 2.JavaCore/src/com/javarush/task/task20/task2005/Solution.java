package com.javarush.task.task20.task2005;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Очень странные дела
*/

public class Solution {
    public static void main(String[] args) {
        //исправь outputStream/inputStream в соответствии с путем к твоему реальному файлу
        try {
            String your_file_name = "C:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2005\\One.txt";
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);

            System.out.println(somePerson.name);
            for (Asset a : somePerson.assets) {
                System.out.println(a.getName());
                System.out.println(a.getPrice());
            }
            Human petrov = new Human("Petrov", new Asset("home"), new Asset("car"));

            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
            System.out.println(ivanov.equals(petrov));
            inputStream.close();

        } catch (IOException e) {
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return false;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            boolean a = name != null ? name.equals(human.name) : human.name == null;
            if (!a)
                return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(name);
            if (assets.size() > 0) {
                for (Asset current : assets) {
                    printWriter.println(current.getName());
                    printWriter.println(current.getPrice());
                }
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            name = reader.readLine();
            ArrayList<String> list = new ArrayList<>();
            String s;
            while ((s = reader.readLine()) != null) {
                list.add(s);
            }
            reader.close();
            for (int i = 0; i < list.size() - 1; i = i + 2) {
                Asset asset = new Asset(list.get(i));
                asset.setPrice(Double.parseDouble(list.get(i + 1)));
                assets.add(asset);
            }
        }
    }
}
