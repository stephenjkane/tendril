
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This main is the implementation used to read in a flat file
 * calculate the mean, medium, range and standard deviation.
 */
public class Interview {
    private double mean;
    private double medium;
    private int lowest;
    private int highest;
    private double stddev;


    public static void main(String args[]){
        Interview main = new Interview();
        try {
            main.run(args);
        }
        catch(RuntimeException exp){
            System.out.println(exp.getMessage());
            System.exit(-1);
        }
    }

    public void run(String args[]){
        if(args.length == 0){
            throw new IllegalArgumentException("Must include the name of the file to read in.");
        }
        List<Integer> list = read(args[0]);
        calculate(list);
        System.out.printf("The mean: %g%n", mean());
        System.out.printf("The medium: %g%n", medium());
        System.out.printf("The range: (lowest) - (highest) %d - %d%n", lowest(), highest());
        System.out.printf("The standard deviation: %g%n", stddev());
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
        // Need to sort to get the range and medium values.
        Collections.sort(data);
        lowest = data.get(0);
        highest = data.get(data.size() - 1);
        if(data.size() % 2 != 0) {
            medium = data.get(data.size() / 2);
        } else {
            int left = (data.size() / 2) - 1;
            int right = (data.size() / 2);
            medium = (data.get(left) + data.get(right)) / (double) 2;
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
    public double medium() {
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
