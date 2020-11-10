package com.company;

import java.util.Arrays;
import java.util.Random;

public class PriorityQueue {

    private int counter = 0;
    private int currentSize;
    private int [ ] array;

    public PriorityQueue(int[] intArray )
    {
        currentSize = intArray.length;
        array = new int[ ( currentSize + 2 )];

        int i = 1;
        for( int item : intArray)
            array[i++] = item;
            counter++;

        buildHeap( );
    }



    public int findMin( )
    {
        return array[ 1 ];
    }


    public int deleteMin( )
    {
        counter++;
        int minItem = findMin( );
        array[ 1 ] = array[ currentSize-- ];
        percolateDown( 1 );

        return minItem;
    }


    private void buildHeap( )
    {
        for( int i = currentSize / 2; i > 0; i-- ){
            percolateDown( i );
            counter++;
        }


    }


    public boolean isEmpty( )
    {
        return currentSize == 0;
    }



    private void percolateDown( int hole )
    {
        int child;
        int tmp = array[ hole ];

        for( ; hole * 2 <= currentSize; hole = child )
        {
            counter++;
            child = hole * 2;
            if( child != currentSize && array[child+1] < array[child] )
                child++;
            if( array[ child ] < tmp )
                array[ hole ] = array[ child ];
            else
                break;
        }
        array[ hole ] = tmp;

    }

  public String selectKthSmallestElement(int k){
        int[] temp = array.clone();
        int element = 0;
        for(int i = 0; i < k; i++){
            element = deleteMin();
        }
        array = temp.clone();

        return "the requested element is " + element;
    }


    public void reset(){
        counter = 0;
    }



    @Override
    public String toString(){
        return Arrays.toString(array);
    }

    public int getCounter() {
        return counter;
    }






}
