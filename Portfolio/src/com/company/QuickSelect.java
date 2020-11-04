package com.company;

public class QuickSelect {


    public int quickSelect(int[] array, int left, int right, int k) {

        int pivot = medianOfThree(array, left, right);

        // Begin partitioning
        int i = left, j = right - 1;
        while (true) {
            while (array[++i] < pivot) {
            }
            while (array[--j] > pivot) {
            }
            if (i < j)
                swap(array, i, j);
            else
                break;
        }

        swap(array, i, right - 1); // Restore pivot
        if (k == pivot) {
            return array[k - 1];
        } else if(k <= i){
            quickSelect(array, left, i - 1, k);
        }
        else if (k > i + 1) {
            quickSelect(array, i + 1, right, k);
        }
        return array[k-1];
    }


    private int medianOfThree(int[] array, int left, int right) {
        int center = left + right / 2;

        if (array[left] > array[center]) {
            swap(array, left, center);
        }
        if (array[left] > array[right]) {
            swap(array, left, right);
        }
        if (array[center] > array[right]) {
            swap(array, center, right);
        }
        swap(array, center, right - 1);

        return array[right - 1];
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


}
