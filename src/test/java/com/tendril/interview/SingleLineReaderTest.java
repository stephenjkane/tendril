package com.tendril.interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SingleLineReaderTest {

    @Test
    public void testRead() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.addAll(Arrays.asList(7, 2, 5, 4, 9, 4, 4, 5));
        SingleLineReader reader = new SingleLineReader("src/test/resources/sample.txt");
        assertEquals(list, reader.read());
    }
}
