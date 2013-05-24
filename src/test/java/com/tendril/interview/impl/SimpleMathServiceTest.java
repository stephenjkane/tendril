package com.tendril.interview.impl;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SimpleMathServiceTest {

    private int[] data;
    private SimpleMathService service;

    @Before
    public void setUp() {
        service = new SimpleMathService();
    }

    @Test
    public void testSample() {
        List data = Arrays.asList(7, 2, 5, 4, 9, 4, 4, 5);
        service.calculate(data);

        assertEquals(5.0, service.mean(), .00001);
        assertEquals(4.5, service.medium(), .00001);
        assertEquals(2, service.lowest());
        assertEquals(9, service.highest());
        assertEquals(2.0, service.stddev(), .00001);
    }

    @Test
    public void testMultiple() {
        List data = Arrays.asList(1, 4, 5, 9);
        service.calculate(data);

        assertEquals("mean is not correct", 4.75, service.mean(), .00001);
        assertEquals("medium is not correct", 4.5, service.medium(), .00001);
        assertEquals("lowest is not correct", 1, service.lowest());
        assertEquals("highest is not correct", 9, service.highest());
        assertEquals("stddev is not correct", Math.sqrt(8.1875), service.stddev(), .0001);

    }

    @Test
    public void testSmall() {
        List data = Arrays.asList(1, 2, 3);
        service.calculate(data);

        assertEquals("mean is not correct", 2.0, service.mean(), .00001);
        assertEquals("medium is not correct", 2, service.medium(), .00001);
        assertEquals("lowest is not correct", 1, service.lowest());
        assertEquals("highest is not correct", 3, service.highest());
        assertEquals("stddev is not correct", Math.sqrt(2/(double)3), service.stddev(), .0001);
    }


}
