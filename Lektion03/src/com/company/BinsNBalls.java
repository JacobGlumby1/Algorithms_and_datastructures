package com.company;

import java.util.*;

public class BinsNBalls {

    Random random;
    private int summizedMax = 0;
    private int averageMax = 0;
    private int maxAmount = 0;
    private int size;
    private int bins[];
    private int runtimes;

    public BinsNBalls(int size, int runtimes) {
        this.size = size;
        this.runtimes = runtimes;
        this.random = new Random(System.currentTimeMillis());
    }

    public void fillBins() {
        int sumofArray = 0;
        int tempAverage = 0;
        for (int i = 0; i < runtimes; i++) {
            this.bins = new int[size];
            for (int j = 0; j < bins.length; j++) {
                int index = random.nextInt(this.bins.length);
                bins[index] += 1;
            }
            int max = Arrays.stream(bins).max().getAsInt();
            summizedMax += max;
            updateMax(max);
        }
        averageMax(summizedMax);
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public int getAverageMax() {
        return averageMax;
    }

    private int averageMax(int value){
        return averageMax = value / runtimes;
    }

    private void updateMax(int value){
        if(value > maxAmount){
            maxAmount = value;
        }
    }
    @Override
    public String toString(){
        return "Experiment with " + size + " bins, and " + runtimes + " tests \n" +
        "results in a max recorded value of " + maxAmount + " and an average of " + averageMax;
    }
}
