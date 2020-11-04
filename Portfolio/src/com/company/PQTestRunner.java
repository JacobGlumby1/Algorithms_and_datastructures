package com.company;

public class PQTestRunner {

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
            int[] array = ag.genArray(arraySize);
            PriorityQ pq = new PriorityQ(array);
            pq.selectKthSmallestElement(array.length-1);
            total += pq.getCounter();
            pq.reset();
        }
        return total / AMOUNT_OF_TESTS_PR_CASE;
    }

}
