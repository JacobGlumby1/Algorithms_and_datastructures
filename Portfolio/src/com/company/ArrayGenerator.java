package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class ArrayGenerator {



    public int[] generateArray(int size) {
        Random r = new Random(System.currentTimeMillis());
        int[] array = r.ints(size, 1, size*8).toArray();
        return array;
    }

    /**
     * @param size
     * @return int array with unique numbers from 0 to size.
     */
    public int[] genArray(int size){
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i = 0; i < size; i++){
            arrList.add(i);
        }
        Collections.shuffle(arrList);
       int[] intArr = new int[size];
        for(int i = 0;i < intArr.length;i++)
            intArr[i] = arrList.get(i);
        return intArr;
    }
}
