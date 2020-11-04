package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Main {

    public static int nLogN(int x) {
        return (int) (x * (Math.log(x) / Math.log(2)));
    }


    public static void main(String[] args) throws IOException {


        PQTestRunner pq = new PQTestRunner();
        QSTestRunner qs = new QSTestRunner();

        CSVwriter cw = new CSVwriter("Priority_Data", "NlogN");
        final int AMOUNT_OF_TESTS_PR_CASE = 100;
        final int AMOUNT_OF_DIFFERENT_TESTS = 100;
        //final int INCREMENT_N = 10000;
        //int N = 10000;
        int N = 10000;
        final int INCREMENT_N = 10000;

        /**
         for(int i = 0;i<AMOUNT_OF_DIFFERENT_TESTS;i++){
         System.out.println(nLogN(N));
         cw.writeData(N,pq.averageOfTests(AMOUNT_OF_TESTS_PR_CASE,N),nLogN(N));
         N += INCREMENT_N;
         }
         */

        CSVwriter cw2 = new CSVwriter("Quicksort_Data", "O(n)");
        for (int i = 0; i < AMOUNT_OF_DIFFERENT_TESTS; i++) {
            cw2.writeData(N, qs.averageOfTests(AMOUNT_OF_TESTS_PR_CASE, N), N);
            N += INCREMENT_N;
        }

        /**
         ArrayGenerator ag = new ArrayGenerator();

         int[] arr = ag.genArray(1000);

         //int[] testarray = {1, 66, 2, 800, 4, 9, 11, 10, 3, 12, 77, 44, 88, 102, 555, 5, 111, 444, 123, 152,166,33,55,78,623,147,785};
         int[] clone = arr.clone();
         QuicksortWiki qsw = new QuicksortWiki();
         System.out.println(qsw.selectKth(arr, 0, arr.length-1, 22-1));

         System.out.println(Arrays.toString(arr));
         Arrays.sort(clone);
         System.out.println(Arrays.toString(clone));
         */


    }
}
