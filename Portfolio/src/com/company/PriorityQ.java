package com.company;

import java.util.Arrays;
import java.util.Random;

public class PriorityQ {

    private int counter = 0;
    private int currentSize;
    private int [ ] array;

    public PriorityQ( int[] intArray )
    {
        currentSize = intArray.length;
        array = new int[ ( currentSize + 2 )];

        int i = 1;
        for( int item : intArray)
            array[i++] = item;
            counter++;

        buildHeap( );
    }


    /**
     * Find the smallest item in the priority queue.
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public int findMin( )
    {
        if( isEmpty( ) )
            throw new RuntimeException("Stack Underflow");
        return array[ 1 ];
    }

    /**
     * Remove the smallest item from the priority queue.
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public int deleteMin( )
    {
        if( isEmpty( ) )
            throw new RuntimeException("Stack Underflow");
        counter++;
        int minItem = findMin( );
        array[ 1 ] = array[ currentSize-- ];
        percolateDown( 1 );

        return minItem;
    }

    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    private void buildHeap( )
    {
        for( int i = currentSize / 2; i > 0; i-- ){
            percolateDown( i );
            counter++;
        }


    }

    /**
     * Test if the priority queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return currentSize == 0;
    }



    /**
     * Percolate items that violate heap order down in the heap.
     * @param hole = index to start at.
     */
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

    @Override
    public String toString(){
        return Arrays.toString(array);
    }

    public int getCounter() {
        return counter;
    }






}
