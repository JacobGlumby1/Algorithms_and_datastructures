package com.company;

import java.util.Arrays;

public class PQcopy {
    private int counter = 0;
    private int currentSize;
    private int [ ] array;

    public PQcopy( int[] intArray )
    {
        currentSize = intArray.length;
        array = new int[ ( currentSize + 2 ) * 11 / 10 ];

        int i = 1;
        for( int item : intArray)
            array[i++] = item;
        counter++;

        buildHeap( );
    }

    /**
     * Insert into the priority queue, maintaining heap order.
     * @param i the item to insert.
     */
    public void insert(int i)
    {
        if( currentSize == array.length - 1 )
            enlargeArray( array.length * 2 + 1 );

        int hole = ++currentSize;
        percolateUp(hole,i);

    }

    private void percolateUp(int hole, int inserted) {
        for( array[ 0 ] = inserted; inserted < array[hole/2]; hole /= 2 ) {
            array[hole] = array[hole / 2];
            counter++;
        }
        array[ hole ] = inserted;
    }

    private void enlargeArray( int newSize )
    {
        int[] old = array;
        array = new int[ newSize ];
        for( int i = 0; i < old.length; i++ )
            array[ i ] = old[ i ];
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
     * Make the priority queue logically empty.
     */
    public void makeEmpty( )
    {
        currentSize = 0;
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


    public void increaseKey(int index, int delta){
        if(delta > 0){
            array[index] += delta;
            percolateDown(index);
        } else {
            System.out.println("new key is not bigger");
        }
    }


    private void decreaseKey(int index, int delta){
        if(delta > 0){
            int newValue = array[index] + delta;
            int hole = index;
            percolateUp(hole,newValue);
        }
    }

    public int selectKthSmallestElement(int k){
        int[] temp = array.clone();
        int element = 0;
        for(int i = 0; i < k; i++){
            element = deleteMin();
        }
        array = temp.clone();

        return element;
    }

    @Override
    public String toString(){
        return Arrays.toString(array);
    }

    public int getCounter() {
        return counter;
    }

}
