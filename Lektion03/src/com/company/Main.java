package com.company;

public class Main {

    public static void main(String[] args) {


	    BinsNBalls bins1 = new BinsNBalls(10007,1000);

	    bins1.fillBins();
        System.out.println(bins1.toString());

        BinsNBalls bins2 = new BinsNBalls(32749,1000);
        bins2.fillBins();
        System.out.println(bins2.toString());



        PowerOfTwo p1 = new PowerOfTwo(10007,1000);
        p1.fillBins();
        System.out.println(p1.toString());

        PowerOfTwo p2 = new PowerOfTwo(32749,1000);
        p2.fillBins();
        System.out.println(p2.toString());
    }
}
