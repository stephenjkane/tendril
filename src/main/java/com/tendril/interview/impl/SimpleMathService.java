package com.tendril.interview.impl;

import com.tendril.interview.MathService;

import java.util.Arrays;
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
        int [] array = new int[data.size()];
        for(int ii = 0; ii < data.size(); ++ii){
            array[ii] = data.get(ii);
        }
        calculateWithArrays(array);
    }

    public void calculateWithArrays(int[] data){
        if(data == null){
            throw new IllegalArgumentException("data must be non-null");
        }
        if(data.length == 0){
            throw new IllegalArgumentException("computing the values on a zero length array is illogical");
        }
        // From the java docs in Arrays.sort method.
        // Implementation note: The sorting algorithm is a Dual-Pivot Quicksort by Vladimir Yaroslavskiy, Jon Bentley,
        // and Joshua Bloch. This algorithm offers O(n log(n)) performance on many data sets that cause other quicksorts
        // to degrade to quadratic performance, and is typically faster than traditional (one-pivot) Quicksort implementations.
        // Sorted or not everything else stays the same.
        Arrays.sort(data);
        if(data.length > 0){
            lowest = data[0];
            highest = data[data.length - 1];
        }
        if(data.length % 2 != 0) {
            medium = data[data.length / 2];
        } else {
            medium = (data[data.length / 2] + data[data.length / 2 + 1]) / 2;
        }
        int sum = 0;
        for(int element : data) {
            sum += element;
        }
        mean = sum / (double) data.length;
        double standard_devation_sum = 0;
        for(int element : data) {
            standard_devation_sum += (element - mean) * (element - mean);
        }
        double variance = standard_devation_sum / (double)data.length;
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
