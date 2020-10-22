package com.company;

import java.util.Arrays;

public class Main {



    public static void main(String[] args) {
	    int[] intArray = new int[] { 1,2,3,4,5,6,7,8,9,10 };
	    boolean[] boolArray = new boolean[] {true,false,false,true,false,true,false};
        boolean[] boolArray2 = new boolean[] {true,true,true,false,false,false};

        SumChecker lc = new SumChecker();

        System.out.println(lc.linearChecker(19, intArray));

        AnagramChecker ac = new AnagramChecker();

        System.out.println(ac.isAnagram("Bell","Lleb"));

        TrueFalseSort tfs = new TrueFalseSort();
        System.out.println("before sort " + Arrays.toString(boolArray));
        tfs.sortBool(boolArray);
        System.out.println("after sort " + Arrays.toString(boolArray));

    }
}
