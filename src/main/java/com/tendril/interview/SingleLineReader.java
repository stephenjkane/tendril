package com.tendril.interview;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * SingleLineReader is class used to read a file and convert the values into an array of integers.
 */
public class SingleLineReader {
    private File file;

    public SingleLineReader(String path) {
        file = new File(path);
    }

    public List<Integer> read() {
        if(!file.exists()){
            throw new RuntimeException("File not found");
        }
        BufferedReader reader = null;
        int lineno = 1;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            List<Integer> integerList = new ArrayList<Integer>();
            while(line != null){
               integerList.add(Integer.valueOf(line.trim()));
                line = reader.readLine();
                ++lineno;
            }
            return integerList;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch(IOException e) {
            throw new RuntimeException("At line number: " + lineno, e);
        } catch(NumberFormatException e) {
            throw new RuntimeException("At line number: " + lineno, e);
        }
    }
}
