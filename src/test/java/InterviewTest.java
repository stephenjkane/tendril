import com.tendril.interview.MathService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class InterviewTest {

    private int[] data;
    private Interview main;

    @Before
    public void setUp() {
        main = new Interview();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRun() {
        main.run(new String[0]);
    }

    @Test(expected = RuntimeException.class)
    public void testNoFile() {
        String[] args = new String[] {"no file.txt"};
        main.run(args);
    }

    @Test
    public void testSample() {
        List data = Arrays.asList(7, 2, 5, 4, 9, 4, 4, 5);
        main.calculate(data);

        assertEquals("mean is not correct", 5.0, main.mean(), .00001);
        assertEquals("medium is not correct", 4.5, main.medium(), .00001);
        assertEquals("lowest is not correct", 2, main.lowest());
        assertEquals("highest is not correct", 9, main.highest());
        assertEquals("stddev is not correct", 2.0, main.stddev(), .00001);
    }

    @Test
    public void testMultiple() {
        List data = Arrays.asList(1, 4, 5, 9);
        main.calculate(data);

        assertEquals("mean is not correct", 4.75, main.mean(), .00001);
        assertEquals("medium is not correct", 4.5, main.medium(), .00001);
        assertEquals("lowest is not correct", 1, main.lowest());
        assertEquals("highest is not correct", 9, main.highest());
        assertEquals("stddev is not correct", Math.sqrt(8.1875), main.stddev(), .0001);

    }

    @Test
    public void testSmall() {
        List data = Arrays.asList(1, 2, 3);
        main.calculate(data);

        assertEquals("mean is not correct", 2.0, main.mean(), .00001);
        assertEquals("medium is not correct", 2, main.medium(), .00001);
        assertEquals("lowest is not correct", 1, main.lowest());
        assertEquals("highest is not correct", 3, main.highest());
        assertEquals("stddev is not correct", Math.sqrt(2/(double)3), main.stddev(), .0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyArray() {
        List data = new ArrayList<Integer>();
        main.calculate(data);
    }
}
