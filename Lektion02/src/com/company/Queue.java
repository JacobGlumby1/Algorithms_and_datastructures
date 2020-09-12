package com.company;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Queue {


    private int front = -1;
    private int back = -1;
    private int currentSize = 0;
    private int theArray[];


    public Queue(int queueSize){
        theArray = new int[queueSize];
    }

    public void enqueue(int number){
        System.out.println("Trying to queue the number " + number);
        if(this.isFull()){
            System.out.println("Queue is full");
        } else {
            this.positionBackPointer();
            currentSize += 1;
            theArray[back] = number;
            System.out.println("Putting the number " + number + " into the queue, at index " + back );
            System.out.println(this.toString());
        }
    }

    public Integer dequeue(){
        System.out.println("Trying to dequeue");
        if(this.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            this.positionFrontPointer();
            currentSize -= 1;
            int returnValue = theArray[front];
            System.out.println("Removing " + returnValue + " at index " + front + " from the queue");
            theArray[front] = 0;
            System.out.println(this.toString());
            return returnValue;
        }
        return null;
    }

    private boolean isFull(){
        return currentSize == theArray.length;
    }
    private boolean isEmpty(){
        return currentSize == 0;
    }

    private void positionFrontPointer(){
        if(front == theArray.length-1){
            front = 0;
        } else {
            front += 1;
        }
    }
    private void positionBackPointer(){
        if(back == theArray.length-1){
            back = 0;
        } else {
            back += 1;
        }
    }


    @Override
    public String toString(){
        return Arrays.toString(theArray);
    }


}
