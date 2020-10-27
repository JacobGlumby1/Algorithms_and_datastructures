package com.company;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Main {

    public static String nLogN(int x)
    {
        return "The result of (N logN) when N = " + x + " is " + (int) (x * (Math.log(x) / Math.log(2)));
    }

    public static void main(String[] args) {
        //int[] ints = new int[]{10, 19, 1, 82, 6, 42, 8, 18, 22, 67, 55, 4, 99, 13, 5,77};

/*
        ArrayGenerator ag = new ArrayGenerator();
        PriorityQ h2 = new PriorityQ(ag.generateArray(10000));
        System.out.println(h2.toString());


        System.out.println(h2.selectKthSmallestElement(9999));
        System.out.println(h2.getCounter());
        System.out.println(nLogN(10000));


*/

        int[] ints = new int[]{10, 19, 1, 82, 6, 42, 8, 18, 22, 67, 55, 4, 99, 13, 5,9};
        System.out.println(Arrays.toString(ints));
        QuickSelect qs = new QuickSelect();
        System.out.println(qs.medianOfThree(ints));
        System.out.println(Arrays.toString(ints));


    }
}
