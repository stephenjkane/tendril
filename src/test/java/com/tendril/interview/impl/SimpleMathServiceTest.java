package com.tendril.interview.impl;

import com.tendril.interview.MathService;
import org.junit.Before;
import org.junit.Test;
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
        data = new int[] {7, 2, 5, 4, 9, 4, 4, 5};
        service.calculateWithArrays(data);

        assertEquals(5.0, service.mean(), .0000001);
        assertEquals(5, service.medium());
        assertEquals(2, service.lowest());
        assertEquals(9, service.highest());
        assertEquals(2.0, service.stddev(), .00001);
    }

    @Test
    public void testSmall() {
        data = new int[] {1, 2, 3};
        service.calculateWithArrays(data);

        assertEquals("mean is not correct", 2.0, service.mean(), .00001);
        assertEquals("medium is not correct", 2, service.medium());
        assertEquals("lowest is not correct", 1, service.lowest());
        assertEquals("highest is not correct", 3, service.highest());
        assertEquals("stddev is not correct", Math.sqrt(2/(double)3), service.stddev(), .0001);
    }

}
