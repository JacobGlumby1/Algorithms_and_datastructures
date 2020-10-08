package com.company;

public class SumChecker {


    public boolean linearChecker(int x, int[] array){
        int front = 0;
        int back = array.length - 1;
        while(front < back){
            int sum = array[front] + array[back];
            if(sum == x){
                return true;
            } else if (sum < x){
                front++;
            } else if(sum>x){
                back--;
            }
        }
        return false;
    }


    public static  boolean quadraticCheck(int checkSumX, int[] sortedArray) {
        int sum = 0;
        int front = 0;
        int back = sortedArray.length - 1;
        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = i; j < sortedArray.length; j++) {
                sum = sortedArray[i] + sortedArray[j];
                if (sum == checkSumX) {
                    return true;
                }
            }
        }
        return false;
    }

}
