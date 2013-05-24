package com.tendril.interview.impl;

import com.tendril.interview.MathService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This is my first attempt at implementing a math service.  It just
 * uses basic java math functions.  It does a very ordinary implementation with
 * little to no optimization.
 */
public class SimpleMathService implements MathService {

    private double mean;
    private int medium;
    private int lowest;
    private int highest;
    private double stddev;

    public SimpleMathService() {

    }

    /**
     * This method takes in a List of Integers.
     * @param data the list of elements.  We pass in an integer list because
     *             it makes testing easier.
     */
    public void calculate(List<Integer> data){
        if(data == null){
            throw new IllegalArgumentException("data must be non-null");
        }
        if(data.size() == 0){
            throw new IllegalArgumentException("computing the values on a zero length array is illogical");
        }
        Collections.sort(data);
        lowest = data.get(0);
        highest = data.get(data.size() - 1);
        if(data.size() % 2 != 0) {
            medium = data.get(data.size() / 2);
        } else {
            medium = (data.get(data.size() / 2) + data.get(data.size() / 2 + 1)) / 2;
        }
        int sum = 0;
        for(int element : data) {
            sum += element;
        }
        mean = sum / (double) data.size();
        double standard_devation_sum = 0;
        for(int element : data) {
            standard_devation_sum += (element - mean) * (element - mean);
        }
        double variance = standard_devation_sum / (double)data.size();
        stddev = Math.sqrt(variance);
    }

    /**
     * Return the mean value
     * @return
     */
    public double mean() {
        return mean;
    }

    /**
     * Return the medium value
     * @return
     */
    public int medium() {
        return medium;
    }

    public int lowest() {
        return lowest;
    }

    public int highest() {
        return highest;
    }

    /**
     * Returns the stddev value
     * @return
     */
    public double stddev() {
        return stddev;
    }

}
