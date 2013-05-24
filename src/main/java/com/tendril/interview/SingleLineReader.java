package com.tendril.interview;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * SingleLineReader is class used to read a file and convert the values into an array of integers.
 */
public class SingleLineReader {

    public SingleLineReader() {
    }

    public List<Integer> read(String path) {
        File file = new File(path);
        if(!file.exists()){
            throw new RuntimeException("File not found");
        }
        int lineno = 1;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
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
            throw new RuntimeException("File: " + file + " At line number: " + lineno, e);
        } catch(NumberFormatException e) {
            throw new RuntimeException("File: " + file + " At line number: " + lineno, e);
        }
    }
}
