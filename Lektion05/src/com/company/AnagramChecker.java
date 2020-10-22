package com.company;

import java.util.Arrays;

public class AnagramChecker {

    // Arrays.sort offers double pivot sort that runs with a O(n log(n))
    // how to sum these big Ohs is still unclear
    public boolean isAnagram(String first, String second){
        char[] firstArray =  first.trim().toLowerCase().toCharArray();
        char[] secondArray = second.trim().toLowerCase().toCharArray();
        Arrays.sort(firstArray);
        Arrays.sort(secondArray);
        if(new String(firstArray).equals(new String(secondArray))){
            return true;
        }
        return false;
    }


}
