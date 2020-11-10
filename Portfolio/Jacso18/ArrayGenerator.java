package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class ArrayGenerator {


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
