package com.company;

public class QuickSelect {


    QuickSelect(){

    }
    QuickSelect(int[] array,int left,int right, int k){

    }

    private int partitioning(){

    }

    public int medianOfThree(int[] array){
        int left = 0;
        int right = array.length-1;
        int center = right / 2;

        if(array[left]>array[center]) {
            swap(array, left, center);
        }
        if(array[left]>array[right]){
            swap(array, left, right);
        }
        if(array[center]>array[right]){
            swap(array,center,right);
        }

        swap(array,center,right-1);

        return array[right-1];
    }

    private void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


}
