package com.company;

public class QuickSelect {

    private int counter = 0;

    public int selectKth(int[] array, int left, int right, int k){
        if(left == right){
            return array[left];
        }
        int pivotIndex = medianOfThree(array, left, right);

        int storageIndex = partition(array,left, right, pivotIndex);

        if(k == storageIndex){
            return array[k];
        } else if(k<storageIndex){
            return selectKth(array,left, storageIndex - 1, k);
        } else {
            return selectKth(array,storageIndex + 1, right, k);
        }
    }
    private int partition(int[] array, int left, int right, int pivotIndex){

        int pivotValue = array[pivotIndex];
        swap(array, pivotIndex, right);
        int storageIndex = left;
        for(int i = left; i < right; i++){
            if(array[i]<pivotValue){
                swap(array,storageIndex,i);
                storageIndex++;
            }
        }
        swap(array, right, storageIndex);
        return storageIndex;
    }
    private void swap(int[] array, int index1, int index2) {
        counter++;
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private int medianOfThree(int[] array, int left, int right) {
        int center = left + right / 2;
        if(center>array.length-1){
            center = array.length-1;
        }

        if (array[left] > array[center]) {
            swap(array, left, center);
        }
        if (array[left] > array[right]) {
            swap(array, left, right);
        }
        if (array[center] > array[right]) {
            swap(array, center, right);
        }

        return center;
    }

    public int getCounter() {
        return counter;
    }

    public void reset(){
        counter = 0;
    }
}
