package com.tendril.interview;

import com.tendril.interview.impl.SimpleMathService;

import java.util.List;

public class Main {

    public static void main(String args[]){
        if(args.length == 0){
            System.out.println("Must include the name of the file to read in.");
            System.exit(-1);
        }
        MathService service = new SimpleMathService();
        SingleLineReader reader = new SingleLineReader(args[0]);
        List<Integer> list = reader.read();
        service.calculate(list);
        System.out.printf("The mean: %g%n", service.mean());
        System.out.printf("The medium: %d%n", service.medium());
        System.out.printf("The range: (low)-(high) %d-%d%n", service.lowest(), service.highest());
        System.out.printf("The standard deviation: %g%n", service.stddev());
    }

}
