package lab3;

import java.util.*;
import java.lang.*;

/**
 * CECS 328 Lab Programming Assignment 3 - Build Max Heap
 * @author Daniel Duong, Meng Moua, Jesse Guardado
 * 3/30/20
 */

/*
 * Here are some functions that we need to know for this assignment: Build - Max - Heap and Max - Heapify
 * Look at pages 152 (parent, left children, right children), 154 (max heapify algorithm), 157 (build max heap) and 153 (6.1-2 proof: n-element has height floor(ln n)).
 */

public class BuildMaxHeap {

    private static int sizeOfHeap;
    //BEWARE THAT THE Algorithms Textbook starting their array index at 1 but java starts theirs at 0 !!!

    /**
     *
     * @param nodeIndex - the node of the heap as an index
     * @return the left child which is 2i (Book), but in java 2i + 1
     */

    private static int left(int nodeIndex) {
        return (2 * nodeIndex) + 1;
        // left child = 2i (Book), but in java, 2i + 1 because java starts the array at 0
    }

    /**
     *
     * @param nodeIndex - the node of the heap as an index
     * @return the right child which is 2i + 1 (Book), but in java 2i + 1 + 1
     */

    private static int right(int nodeIndex) {
        return (2 * nodeIndex) + 2;
        // right child = 2i + 1 (Book) (PEMDAS), but in java, 2i + 1 + 1 because java starts the array at 0
    }

    /**
     *
     * @param ar - the array of integers that we will be building our max heap with
     */

    public static void BuildMaxHeap(int ar[]) { // Translation from pg.157 section 6.3
        sizeOfHeap = ar.length; // initialing size of the heap

        for(int i = (ar.length /2) - 1; i >= 0; i--) { // in order to factor in that arrays start at index 0 not at 1:
            maxHeapify(ar, i);
        }
    }

    /**
     *
     * @param ar - the array of integers that is going to be sorted to become the max heap
     * @param i - the index of the parent as an integer
     */

    public static void maxHeapify(int ar [], int i) { // Translation from pg.154 section 6.2

        //System.out.println("Calling max heapify on node: " + i);

        int l = left(i); // representation of the left child
        //System.out.println("The left child is: " + l);

        int r = right(i); // representation of the right child
        //System.out.println("The right child is: " + r);

       //System.out.println("Comparing left children node: " + l + " right children node: " + r);

        int largest; // because we did start comparing the node values of the parent and the left children, only initialize the largest

        // map heapify always compares the parent node with the left child first

        if (l < sizeOfHeap && ar[l] > ar[i]) { // if the value of the left child is bigger than the parent
            //System.out.println("Value of left child: " + ar[l]);
            //System.out.println("Value of right child: " + ar[r]);
            largest = l; // the left child is the largest
        }

        else { // if the value of the parent node is greater than the value of the left children
            largest = i; // the parent is the largest
        }

        // note that the largest will either become l or i depending on how the heap is presented at the moment.
        // one case is that the root is the largest and you will have to compare the root versus the right child.
        // another case is that the left child is the largest and you will have to compare the left child versus the right child.

        if (r < sizeOfHeap && ar[r] > ar[largest]) { // if the value of the right child is bigger than the value of the largest node (either the parent or the left child)
            //System.out.println("Value of left child: " + ar[l]);
            //System.out.println("Value of left child: " + ar[r]);
            largest = r; // the right child is the largest
        }

        //System.out.println("Largest should be: " + largest);

        if (largest != i) {
            //System.out.println("Going to recursively call maxheapify " + "\n");
            int temporaryVar = ar[i];
            ar[i] = ar[largest];
            ar[largest] = temporaryVar;
            // note that the reason why we get index out of bounds error is because arrays start at index 0, but the book starts it at 1
            maxHeapify(ar, largest); // recursive call for max heapify according to the algorithm.
        }
    }

    /**
     *
     * @param sizeOfHeap - the size of the heap as an integer (number of nodes)
     * @return the height of the heap which is figured out by calculating the ln (log 2) of the size of the heap
     */

    public static int getHeapHeight(int sizeOfHeap) {
        // suppose that the height of the heap is the ln (log base 2) of the size of the heap
        // on the calculator to finding the ln of a value
        // you would type in log base of the size of the heap divided by log base 2
        // thankfully, java has the Math.log built in function to take the log of any number
        int heapHeight;

        if (sizeOfHeap == 0) {
            heapHeight = -1; // a way to handle an empty array, empty heap
            return heapHeight;
        }
            // if the heap size is at least one or greater, run the ln of the size of the heap
            heapHeight = (int) ((Math.log(sizeOfHeap) / Math.log(2)));
            return heapHeight;
    }

    /**
     * A function to display an array set
     * @param inputSet set of array
     */
    public static void display(int[] inputSet)
    {
        int end = inputSet.length - 1;
        int z = 0;
        for (int i : inputSet)
        {
            if (z != end)
                System.out.print(i + " ");  //print a digit with a space
            else
                System.out.print(i);    //print last digit
            z++;
        }
        System.out.println("\n");
    }

    public static void main (String[] args) {

        int[] intSet = new int[args.length]; // COMMAND LINE TESTING
        int index = 0;

        for (String s : args) {
            intSet[index] = Integer.parseInt(s);
            index++;
        }

        BuildMaxHeap(intSet);
        System.out.println("Max Heap Array: ");
        display(intSet);

        System.out.println("Height: " + getHeapHeight(sizeOfHeap));

        // TEST CASES
        //int[] ar = new int []{4, 5, 1, 7, 3, 3, 8};
        //int [] ar = new int [] {-2, 5, 7, 3, 5};
        //int[] ar = new int []{0}; // single element
        //int ar[] = new int []{}; // empty array
        //int[] ar = new int []{-1, -1, -1, -1}; // duplicates
        //int[] ar = new int []{2, 3, 5, 8, 13, 21, 34, 55}; // fibonacci sequence
        //int [] ar = new int[] {8, 21, 13, 52, 13, 91, 100, 1, 76, 36, 75, 47, 5, 81, 77, 34, 91, 3, 83, 13};

    } // end of the main function
} // end of entire java class
