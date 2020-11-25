package com.company;

public class Driver {



    public static int MinimumSteps(int BoardHeight, int BoardWidth, int KnightStartXPosition,
                                   int KnightStartYPosition, int KnightEndXPosition, int KnightEndYPosition) {

        Tree tree = new Tree(BoardHeight,BoardWidth,KnightStartXPosition,KnightStartYPosition,KnightEndXPosition,KnightEndYPosition);

        return tree.getEndNode().getDepth();
    }

    public static void main(String[] args) {

        // The example provided.
        System.out.println(MinimumSteps(8,8,4,4,3,2));


    }

}
