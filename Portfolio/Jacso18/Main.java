package com.company;

import java.io.IOException;

public class Main {




    public static void main(String[] args) throws IOException {

        final int SIZE = 100;
        final int K = SIZE;
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        int[] array = arrayGenerator.genArray(SIZE);


        /**
         * Driver code for the priority queue.
         */
        PriorityQueue pq = new PriorityQueue(array);
        System.out.println(pq.selectKthSmallestElement(K));
        System.out.println("Counter value priority queue: " + pq.getCounter());
        pq.reset();

        /**
         * Driver code for the quick select.
         */
        array = arrayGenerator.genArray(SIZE);
        QuickSelect qs = new QuickSelect();
        System.out.println("Kth element is: " + qs.selectKth(array,0, array.length-1,K-1));
        System.out.println("Counter value quickselect: " +qs.getCounter());
        qs.reset();

    }
}
