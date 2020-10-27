package com.company;

import java.util.Random;

public class ArrayGenerator {



    public int[] generateArray(int size) {
        Random r = new Random(System.currentTimeMillis());
        int[] array = r.ints(size, 1, 2000).toArray();
        return array;
    }
}
