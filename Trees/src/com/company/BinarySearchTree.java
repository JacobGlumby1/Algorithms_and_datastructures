package com.company;// BinarySearchTree class

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// boolean contains( x )  --> Return true if x is present
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo method.
 *
 * @author Mark Allen Weiss
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
    /**
     * The tree root.
     */
    private BinaryNode<AnyType> root;

    /**
     * Construct the tree.
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Insert into the tree; duplicates are ignored.
     *
     * @param x the item to insert.
     */
    public void insert(AnyType x) {
        root = insert(x, root);
    }

    public void buildPerfect(AnyType[] sortedArray){
        root = buildPerfect(sortedArray,0,sortedArray.length-1);
    }
    public BinaryNode<AnyType> buildPerfect(AnyType[] sortedArray, int start, int end){
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        BinaryNode node = new BinaryNode(sortedArray[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = buildPerfect(sortedArray, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = buildPerfect(sortedArray, mid + 1, end);

        return node;
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     *
     * @param x the item to remove.
     */
    public void remove(AnyType x) {
        root = remove(x, root);
    }

    /**
     * Find the smallest item in the tree.
     *
     * @return smallest item or null if empty.
     */
    public AnyType findMin() {
        if (isEmpty())
            throw new RuntimeException();
        return findMin(root).element;
    }

    /**
     * Find the largest item in the tree.
     *
     * @return the largest item of null if empty.
     */
    public AnyType findMax() {
        if (isEmpty())
            throw new RuntimeException();
        return findMax(root).element;
    }

    /**
     * Find an item in the tree.
     *
     * @param x the item to search for.
     * @return true if not found.
     */
    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty() {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree() {
        if (isEmpty())
            System.out.println("Empty tree");
        else
            printTree(root);
    }

    /**
     * Internal method to insert into a subtree.
     *
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return new BinaryNode<>(x, null, null);

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = insert(x, t.left);
        else if (compareResult > 0)
            t.right = insert(x, t.right);
        else
            ;  // Duplicate; do nothing
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     *
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return t;   // Item not found; do nothing

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) // Two children
        {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else
            t = (t.left != null) ? t.left : t.right;
        return t;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     *
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t == null)
            return null;
        else if (t.left == null)
            return t;
        return findMin(t.left);
    }

    /**
     * Internal method to find the largest item in a subtree.
     *
     * @param t the node that roots the subtree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        if (t != null)
            while (t.right != null)
                t = t.right;

        return t;
    }

    /**
     * Internal method to find an item in a subtree.
     *
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return node containing the matched item.
     */
    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return false;

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0)
            return contains(x, t.right);
        else
            return true;    // Match
    }

    /**
     * Internal method to print a subtree in sorted order
     *
     * @param t the node that roots the subtree.
     */
    private void printTree(BinaryNode<AnyType> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    /**
     * Internal method to compute height of a subtree.
     *
     * @param t the node that roots the subtree.
     */
    private int height(BinaryNode<AnyType> t) {
        if (t == null)
            return -1;
        else
            return 1 + Math.max(height(t.left), height(t.right));
    }


    /**
     * Adds all nodes from the tree to a ArrayList. Return the size of the list.
     *
     * @param t is the root node.
     * @return tree size.
     */
    public int countNodes(BinaryNode<AnyType> t) {
        ArrayList<BinaryNode<AnyType>> list = new ArrayList<>();
        list.add(t);
        for (int i = 0; i < list.size(); i++) {
            BinaryNode temp = list.get(i);
            if (temp.left != null) {
                list.add(temp.left);
            }
            if (temp.right != null) {
                list.add(temp.right);
            }
        }
        return list.size();
    }

    public int countFullNodes(BinaryNode<AnyType> t) {
        int count = 0;
        LinkedList<BinaryNode<AnyType>> list = new LinkedList<>();
        list.add(t);
        while (!list.isEmpty()) {
            BinaryNode tempnode = list.poll();
            if (tempnode.left != null && tempnode.right != null) {
                count++;
            }
            if (tempnode.left != null) {
                list.add(tempnode.left);
            }
            if (tempnode.right != null) {
                list.add(tempnode.right);
            }
        }
        return count;
    }

    /**
     * Traverse the tree in level order, count the amount of leaves.
     *
     * @param t root node
     * @return number of leaves
     */
    public int countLeaves(BinaryNode<AnyType> t) {
        int count = 0;
        LinkedList<BinaryNode<AnyType>> list = new LinkedList<>();
        list.add(t);
        while (!list.isEmpty()) {
            BinaryNode tempnode = list.poll();
            if (tempnode.left == null && tempnode.right == null) {
                count++;
            }
            if (tempnode.left != null) {
                list.add(tempnode.left);
            }
            if (tempnode.right != null) {
                list.add(tempnode.right);
            }
        }
        return count;
    }

    public int internalPathLength(BinaryNode<AnyType> t, int level) {
        if (t == null){
            return 0;
        } else{
            return (internalPathLength(t.left, level + 1) + level + internalPathLength(t.right, level + 1));
        }
    }


    public void postOrderTraverse(BinaryNode<AnyType> t) {
        if (t == null) {
            return;
        }
        postOrderTraverse(t.left);
        postOrderTraverse(t.right);
        System.out.println(t.element);

    }

    public void preOrderTraverse(BinaryNode<AnyType> t) {
        if (t == null) {
            return;
        }
        System.out.println(t.element);
        preOrderTraverse(t.left);
        preOrderTraverse(t.right);
    }

    public void levelOrderTraverse(BinaryNode<AnyType> t) {
        LinkedList<BinaryNode<AnyType>> list = new LinkedList<>();
        list.add(t);
        while (!list.isEmpty()) {
            BinaryNode tempnode = list.poll();
            System.out.println(tempnode.element);
            if (tempnode.left != null) {
                list.add(tempnode.left);
            }
            if (tempnode.right != null) {
                list.add(tempnode.right);
            }
        }
    }


    // Array generator.
    public int[] genArray(int size) {
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrList.add(i);
        }
        Collections.shuffle(arrList);
        int[] intArr = new int[size];
        for (int i = 0; i < intArr.length; i++)
            intArr[i] = arrList.get(i);
        return intArr;
    }

    // Basic node stored in unbalanced binary search trees
    private static class BinaryNode<AnyType> {
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;

        BinaryNode(AnyType theElement) {
            this(theElement, null, null);
        }

        BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }


    }


    // Test program
    public static void main(String[] args) {


        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        int[] array = t.genArray(10);
        /**
         final int NUMS = 4000;
         final int GAP = 37;

         System.out.println("Checking... (no more output means success)");

         for (int i = GAP; i != 0; i = (i + GAP) % NUMS)
         t.insert(i);

         for (int i = 1; i < NUMS; i += 2)
         t.remove(i);


         if (NUMS < 40)
         t.printTree();
         if (t.findMin() != 2 || t.findMax() != NUMS - 2)
         System.out.println("FindMin or FindMax error!");
         */

        for (int i = 0; i < array.length; i++) {
            t.insert(array[i]);
        }

        /**
         System.out.println("Root is: " + t.root.element);
         System.out.println("Left is: " + t.root.left.element);
         System.out.println("Right is: " + t.root.right.element);

         System.out.println("Post order traverse");
         t.postOrderTraverse(t.root);

         System.out.println("Pre order traverse");
         t.preOrderTraverse(t.root);
         */
        System.out.println("Level order traverse");
        t.levelOrderTraverse(t.root);
        System.out.println("The tree consists of: " + t.countNodes(t.root) + " Nodes");
        System.out.println("The tree consists of: " + t.countLeaves(t.root) + " Leaves");
        System.out.println("The tree consists of: " + t.countFullNodes(t.root) + " Full nodes");
        System.out.println("Internal path length is " + t.internalPathLength(t.root, 0));

        BinarySearchTree<Integer> t2 = new BinarySearchTree<>();
        Integer[] integerArray = new Integer[] {1,2,3,4,5,6,7};

        t2.buildPerfect(integerArray);
        t2.levelOrderTraverse(t2.root);

        /*
        for (int i = 2; i < NUMS; i += 2)
            if (!t.contains(i))
                System.out.println("Find error1!");

        for (int i = 1; i < NUMS; i += 2) {
            if (t.contains(i))
                System.out.println("Find error2!");
        }

         */
    }
}
