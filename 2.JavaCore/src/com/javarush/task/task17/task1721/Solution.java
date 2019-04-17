package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String x = reader.readLine();
        String y = reader.readLine();
        reader.close();

        InputStream inStream = new FileInputStream(x);
        BufferedReader xxx = new BufferedReader(new InputStreamReader(inStream));
        String strLine;
        while ((strLine = xxx.readLine()) != null){
            allLines.add(strLine);
        }
        inStream = new FileInputStream(y);
        xxx = new BufferedReader(new InputStreamReader(inStream));
        while ((strLine = xxx.readLine()) != null){
            forRemoveLines.add(strLine);
        }

        xxx.close();
        inStream.close();
        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {

        }

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
                allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}