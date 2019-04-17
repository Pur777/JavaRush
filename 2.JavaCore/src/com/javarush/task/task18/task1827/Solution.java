package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String z = reader.readLine();
        if (args.length != 0) {
            ArrayList<String> product = solution.getProduct(z);
            String total = solution.getId(product) + solution.total(args);
            solution.writer(total, z);
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
    public void writer(String product, String fileOut) {
        OutputStream outputStream = null;
        BufferedWriter bufferedWriter = null;
        try {
            outputStream = new FileOutputStream(fileOut, true);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.newLine();
            bufferedWriter.write(product);
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
    public String getId(ArrayList<String> list) {
        ArrayList<Integer> ids = new ArrayList<>();
        for (String s : list) {
            ids.add(Integer.parseInt(s.substring(0, 8).trim()));
        }
        int id = Collections.max(ids) + 1;
        String idd = String.valueOf(id);
        int leught = idd.length();
        String space = "";
        for (int i = 0; i < 8 - leught; i++) {
            space += " ";
        }
        return idd + space;
    }
    public String total(String[] li) {
        String demoProductName = li[1];
        String demoPrice = li[2];
        String demoQuantity = li[3];

        int leught = demoProductName.length();
        String space = "";
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

        return productName + price + quantity;
    }
}