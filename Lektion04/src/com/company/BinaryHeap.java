package com.company;

// BinaryHeap class
//
// CONSTRUCTION: with optional capacity (that defaults to 100)
//               or an array containing initial items
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// Comparable deleteMin( )--> Return and remove smallest item
// Comparable findMin( )  --> Return smallest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Implements a binary heap.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */
public class BinaryHeap<AnyType extends Comparable<? super AnyType>>
{
    /**
     * Construct the binary heap.
     */
    public BinaryHeap( )
    {
        this( DEFAULT_CAPACITY );
    }

    /**
     * Construct the binary heap.
     * @param capacity the capacity of the binary heap.
     */
    public BinaryHeap( int capacity )
    {
        currentSize = 0;
        array = (AnyType[]) new Comparable[ capacity + 1 ];
    }

    /**
     * Construct the binary heap given an array of items.
     */
    public BinaryHeap( AnyType [ ] items )
    {
        currentSize = items.length;
        array = (AnyType[]) new Comparable[ ( currentSize + 2 ) * 11 / 10 ];

        int i = 1;
        for( AnyType item : items )
            array[ i++ ] = item;
        buildHeap( );
    }

    /**
     * Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     * @param x the item to insert.
     */
    public void insert( AnyType x )
    {
        if( currentSize == array.length - 1 )
            enlargeArray( array.length * 2 + 1 );


        // Percolate up
        int hole = ++currentSize;
        for( array[ 0 ] = x; x.compareTo( array[ hole / 2 ] ) < 0; hole /= 2 )
            array[ hole ] = array[ hole / 2 ];
        array[ hole ] = x;

         }


    private void enlargeArray( int newSize )
    {
        AnyType [] old = array;
        array = (AnyType []) new Comparable[ newSize ];
        for( int i = 0; i < old.length; i++ )
            array[ i ] = old[ i ];
    }

    /**
     * Find the smallest item in the priority queue.
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public AnyType findMin( )
    {
        if( isEmpty( ) )
            throw new RuntimeException("Stack Underflow");
        return array[ 1 ];
    }

    /**
     * Remove the smallest item from the priority queue.
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public AnyType deleteMin( )
    {
        if( isEmpty( ) )
            throw new RuntimeException("Stack Underflow");

        AnyType minItem = findMin( );
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
        for( int i = currentSize / 2; i > 0; i-- )
            percolateDown( i );
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

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;      // Number of elements in heap
    private AnyType [ ] array; // The heap array




    /**
     * Internal method to percolate down in the heap.
     * @param hole the index at which the percolate begins.
     */
    private void percolateDown( int hole )
    {
        int child;
        AnyType tmp = array[ hole ];

        for( ; hole * 2 <= currentSize; hole = child )
        {
            child = hole * 2;
            if( child != currentSize &&
                    array[ child + 1 ].compareTo( array[ child ] ) < 0 )
                child++;
            if( array[ child ].compareTo( tmp ) < 0 )
                array[ hole ] = array[ child ];
            else
                break;
        }
        array[ hole ] = tmp;
        
    }

    // Implement increase key
    public void increaseKey(int index, AnyType newValue){
        if(index <= currentSize && array[index].compareTo(newValue) < 0){
            array[index] = newValue;
            percolateDown(index);
        } else {
            System.out.println("new key is not bigger");
        }
    }

    // implement decrease key
    private void decreaseKey(int index, AnyType newValue){
        if(index <= currentSize && array[index].compareTo(newValue)>0){
            int hole = index;
            for( ; newValue.compareTo( array[ hole / 2 ] ) < 0; hole /= 2 )
                array[ hole ] = array[ hole / 2 ];
            array[ hole ] = newValue;
        }

    }
    @Override
    public String toString(){
        return Arrays.toString(array);
    }

    // Test program
    public static void main( String [ ] args )
    {
        int numItems = 50;
        BinaryHeap<Integer> h = new BinaryHeap<>( );
        int i = 37;

        for( i = 37; i != 0; i = ( i + 37 ) % numItems )
            h.insert( i );
        h.increaseKey(1, 88);
        h.decreaseKey(6,5);

        /** exercise 01, illustrate what happens when you insert following numbers, one by one */
        System.out.println("Exercise 01, start");
        BinaryHeap<Integer> h2 = new BinaryHeap<>( );
        int[] ints = new int[]{10, 12, 1, 14, 6, 5, 8, 15, 3, 9, 7, 4, 11, 13, 2};
        for(int j = 0;j<ints.length;j++){
            h2.insert(ints[j]);
            System.out.println(h2.toString());
        }
        System.out.println("Exercise 01, end \n");

        /** Exercise 02 Show the result of performing three deleteMin operations in the heap of the previous exercise. */
        System.out.println("Exercise 02, start");
        System.out.println(h2.toString());
        for(int k = 0; k<3;k++){
            h2.deleteMin();
            System.out.println(h2.toString());

        }
        System.out.println("Exercise 02, end");


        /** Exercise 03 Write pseudocode to check heap order in binary tree */
        /**
         *  Using a simple queue system:
         *
         *  int nodeValue;
         *
         *  queue.enqueue(root)
         *  while !queue.isEmpty
         *      node = queue.dequeue();
         *      nodeValue = node.getValue();
         *      if node.left != null
         *          if node.left.getValue() < nodeValue
         *              return false;
         *          else
         *              queue.enqueue(left);
         *      if node.right != null
         *          if node.right.getValue() < nodeValue
         *              return false;
         *          else
         *              queue.enqueue(right);
         *
         *  return true
         */

        /** Exercise 03 Write pseudocode to check heap order in binary heap, array implementation */
        /**
         *
         *
         *  for(int i = 0; i<array.length; i++)
         *      node = array[i];
         *      if array[i * 2] != null
         *          if node.compareTo(array[i*2]) > 0           // compare value > 0, then the number at array[i] is larger than array[i*2]
         *             return false;
         *      if array[i*2+1] != null
         *          if node.compareTo(array[i*2+1]) > 0
         *              return false;
         *  return true;
         *
         *
         */

        /**
        for( i = 1; i < numItems; i++ )
            if( h.deleteMin( ) != i )
                System.out.println( "Oops! " + i );
*/
         }


}