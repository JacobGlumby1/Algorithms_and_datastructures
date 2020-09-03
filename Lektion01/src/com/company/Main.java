package com.company;

public class Main {

    // tallet x + x-1 + x-2 + x-3 osv. indtil 0.
    public static int sum(int x) {
        if (x == 0) {
            return 0;
        } else {
            return sum(x - 1) + x;
        }
    }


    public static int evenSquares(int n) {
        if (n == 0) {
            return 0;
        } else if (n % 2 == 0) {
            return evenSquares(n - 2) + n * n;
        } else {
            return evenSquares(n - 1);
        }
    }


    //returns the nth Fibonacci number
    public static int fib(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    //returns true if string s with the length l contains
    //char c; otherwise false.
    public static boolean linear(String s, char c, int l) {
        if(l < 0){
            return false;
        }
        if(s.charAt(l) == c){
            return true;
        } else {
            return linear(s,c,l-1);
        }


    }


    public static void main(String[] args) {

        System.out.println(sum(3));

        System.out.println(evenSquares(4));

        System.out.println(fib(10));

        String s = "Hej";
        System.out.println(linear(s,'j',s.length() - 1));
    }

}
