package com.tendril.interview;

import java.util.List;

/**
 * A service used to calculate the mean, median, range, and standard deviation.
 *
 */
public interface MathService {

    /**
     * Returns the mean value of the data
     * @return
     */
    public double mean();

    /**
     * Returns the medium value of the data
     */
    public int medium();

    /**
     * Returns the lowest value range
     */
    public int lowest();

    /**
     * Returns the highest value range
     */
    public int highest();

    /**
     * Returns the standard deviation.
     */
    public double stddev();

    /**
     * Use this data to calculate the data.
     * @param data
     */
    public void calculate(List<Integer> data);
}
