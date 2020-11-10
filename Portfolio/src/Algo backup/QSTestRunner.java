package com.company;

public class QSTestRunner {

    /**
     *
     * @param AMOUNT_OF_TESTS_PR_CASE
     * @param arraySize used for the array generator, and to select the last element
     * @return the average of the tests
     */
    public int averageOfTests(int AMOUNT_OF_TESTS_PR_CASE, int arraySize){
        int total = 0;
        for(int i = 0; i < AMOUNT_OF_TESTS_PR_CASE; i++){
            ArrayGenerator ag = new ArrayGenerator();
            QuickselectWiki qs = new QuickselectWiki();
            int[] array = ag.genArray(arraySize);
            qs.selectKth(array, 0, array.length-1,array.length/2-1);
            total += qs.getCounter();
            qs.reset();
        }
        return total / AMOUNT_OF_TESTS_PR_CASE;
    }


}
