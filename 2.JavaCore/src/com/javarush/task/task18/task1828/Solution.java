package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String z = reader.readLine();
        if (args.length != 0) {
            ArrayList<String> product = solution.getProduct(z);
            if (args[0].equals("-u")) {
                String total = solution.total(args);
                solution.editing(product, args[1], total);
            } else if (args[0].equals("-d")) {
                solution.deletion(product, args[1]);
            }
            solution.writing(product, z);
        }
    }
    public ArrayList<String> getProduct(String s) {
        ArrayList<String> list = new ArrayList<>();
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = new FileInputStream(s);
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String str;
            while ((str = reader.readLine()) != null) {
                list.add(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    public String total(String[] li) {
        String demoId = li[1];
        String demoProductName = li[2];
        String demoPrice = li[3];
        String demoQuantity = li[4];

        int leught = demoId.length();
        String space = "";
        for (int i = 0; i < 8 - leught; i++) {
            space += " ";
        }
        String id = demoId + space;

        leught = demoProductName.length();
        space = "";
        for (int i = 0; i < 30 - leught; i++) {
            space += " ";
        }
        String productName = demoProductName + space;

        leught = demoPrice.length();
        space = "";
        for (int i = 0; i < 8 - leught; i++) {
            space += " ";
        }
        String price = demoPrice + space;

        leught = demoQuantity.length();
        space = "";
        for (int i = 0; i < 4 - leught; i++) {
            space += " ";
        }
        String quantity = demoQuantity + space;

        return id + productName + price + quantity;
    }
    public void editing(ArrayList<String> list, String getId, String editProduct) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).substring(0, 8).trim().equals(getId)) {
                list.set(i, editProduct);
            }
        }
    }
    public void deletion(ArrayList<String> list, String getId) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).substring(0, 8).trim().equals(getId)) {
                list.remove(i);
            }
        }
    }
    public void writing(ArrayList<String> product, String fileOut) {
        OutputStream outputStream = null;
        BufferedWriter bufferedWriter = null;
        try {
            outputStream = new FileOutputStream(fileOut);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            for (String s : product) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}