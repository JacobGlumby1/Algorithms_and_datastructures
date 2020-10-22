package com.company;

public class TrueFalseSort {

    /**
     * Suppose you have an array of N elements containing only two distinct keys, true
     * and false. Give an O(N) algorithm to rearrange the list so that all false elements
     * precede the true elements. You may use only constant extra space.
     */

    public void sortBool(boolean[] array) {
        int front = 0;
        int back = array.length - 1;
        while (front < back) {
            if (array[back] == false) {
                if (array[front] == true) {
                    array[front] = false;
                    array[back] = true;
                    front++;
                    back--;
                } else {
                    front++;
                }
            } else {
                back--;
            }
        }
    }


}
