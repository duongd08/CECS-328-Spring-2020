package lab4;

import java.util.*; // this imports a lot of things such as arrays, scanners, arraylists, collections, etc.

/**
 * CECS 328 Lab Programming Assignment 4 - Max Priority Queue (E.C.)
 * @author Daniel Duong, Meng Moua, Jesse Guardado
 * 3/27/20
 */

 /*Here are some functions that we need to know for this assignment: build max heap, max heapify, heap maximum, heap extract max, and heap increase key
  We found there algorithms from page 152 (nodes: parent, left children, right children), page 154 (max heapify algorithm), 157 (build max heap)
 page 163 (heap maximum), page 163 (heap extract max), and page 164 (heap increase key)
 /*

/* Swapping guide: C++ - Pass by reference
 void (int&a, int&b, int&c) {
 int temp; // swapping guide
 temp = a;
 a = b;
 b = c;
 c = temp;
 temp = c;
 }
 */

public class MaxPriorityQueue {

    public static void displayMenu() { // void function to display the menu options
        System.out.println("1. Insert");
        System.out.println("2. Maximum");
        System.out.println("3. Extract-Max");
        System.out.println("4. Increase-Key");
        System.out.println("5. Exit");
    }

    /**
     *
     * @param nodeIndex - the index of the node as an integer
     * @return the left child which is 2i (Book), but in java 2i + 1
     */

    private static int left(int nodeIndex) {
        return (2 * nodeIndex) + 1; // we return 2i + 1 but not 2i for the left child because java has arrays and arraylists position starting at 0.
    }

    /**
     *
     * @param nodeIndex - the index of the node as an integer
     * @return the right child which is 2i + 1(Book), but in java 2i + 1 + 1
     */

    private static int right(int nodeIndex) {
        return (2 * nodeIndex) + 2; // we return 2i + 2 but not 2i + 1 for the right child because java has arrays and arraylists position starting at 0.
    }

    // prior to heading into switch case

    /**
     *
     * @param ar - the arraylist of integers that we will build our max heap on
     */
    public static void buildMaxHeap(ArrayList<Integer> ar) {
        int heapSize = ar.size();

        for (int i = (ar.size() / 2) - 1; i >= 0; i--) {  // in order to factor in that arrays and arraylists start at index 0 not at 1:
            maxHeapify(ar, i); // call maxHeapify
        }
    }

    // part of build max heap (called inside buildMaxHeapFunction)
    /**
     *
     * @param ar - the arraylist of integers that we will perfoming max heapify on
     * @param i - the index of the node as an integer to keep track of where we are calling max heapify on
     */
    public static void maxHeapify(ArrayList<Integer> ar, int i) {

        // Testing/Debugging purposes
        //System.out.println("Calling max heapify on node: " + i);

        int l = left(i); // l is the left child of node i (2i + 1)
        //System.out.println("Left children is: " + l);

        int r = right(i); // r is the right child of node i (2i + 2)
        //System.out.println("Right children is : " + r);

        int largest; // for now only initialize largest because we have not compared anything yet

        // the parent node will compare with the left child prior to any other comparisons
        // also, note that the translation if (l < ar.length && ar[l] > ar[i]) for arrays to arraylists
        // should be if (l < ar.size() && ar.get(l) > ar.get(i))

        if (l < ar.size() && ar.get(l) > ar.get(i)) { // if the left node is less than the size of the heap and the value of the left child is greater than the value of the parent node
            // Testing/Debugging purposes
            //System.out.println("Value of A[l] is: " + ar.get(l));
            //System.out.println("Value of A[i] is: " + ar.get(i));
            largest = l; // largest becomes l if the value of the left child is bigger than the value of the parent node
        }

        else { // if the value of the left child is not greater than the value of the parent
            largest = i; // largest becomes i if the value of the left child is greater than the value of the parent
        }

        // prior to checking the value of the right children, the largest will either be the parent node or the left node

        if (r < ar.size() && ar.get(r) > ar.get(largest)) {// if the right node is less than the size of the heap and the value of the left child is greater than the value of the parent node
            // Testing/Debugging purposes
            //System.out.println("Value of A[r] is: " + ar.get(r));
            //System.out.println("Value of A[largest] is: " + ar.get(largest));
            largest = r;
        }

        //System.out.println("Largest is: " + largest);

        if (largest != i) {

            // Testing/Debugging purposes
            //System.out.println("Value of A[i] before the exchange:  " + ar.get(i));
            //System.out.println("Value of A[largest] before the exchange: " + ar.get(largest));

            Collections.swap(ar, i, largest); // exchange A[i] with A[largest]: Collections allow us to directly swap indexes of arraylists

            // Testing/Debugging purposes
            //System.out.println("Value of A[i] after the exchange: " + ar.get(i));
            //System.out.println("Value of A[largest] after the exchange: " + ar.get(largest));

            /* Another way to swap values of arraylists is by using set
             * Set takes in 2 parameters, the index i and the index where you want to swap your values.
             * java has the set method which is the appropriate method for arraylists
             */
            maxHeapify(ar, largest); // recursive call max heapify on the largest
        }
    }

    // Case 1 - Insert
    /**
     *
     * @param ar - the arraylist of integers that we will be adding a new value to
     * @param key - the value of the new node (last element of arraylist) as an integer
     */
    public static void maxHeapInsert(ArrayList<Integer> ar, int key) {
        //ar.size() += 1;
        int temporaryVar = Integer.MIN_VALUE; // negative infinity representation in java
        ar.add(temporaryVar); // add the node that contains the value of negative infinity and it will go to the end of the heap
        //.add increases the size of the arraylist by 1

        // Testing/Debugging purposes
        /*System.out.println("Array after adding a new node with the value of negative infinity: ");
        for(int i = 0; i < ar.size(); i++) {
            System.out.print(ar.get(i) + " ");
        } // INTEGER.MIN_VALUE should be at the end of the arraylist

        System.out.println();*/
        heapIncreaseKey(ar, ar.size() - 1, key); // call heapIncreaseKey. ar.size() -1 represents access to the last element in an arraylist
    }

    // Case 4 - Increase Key
    /**
     *
     * @param ar - the arraylist of integers that we will be increasing a key to it's respective node
     * @param i - the index of the node to keep track of which node are modifying the value of
     * @param key - value of the new node (last element of arraylist) as an integer
     */
    public static void heapIncreaseKey(ArrayList<Integer> ar, int i, int key) {

        // Testing/Debugging purposes
        //System.out.println("The key is: " + key);
        //System.out.println("A[i] is: " + ar.get(i));

        if (key < ar.get(i)) { // if the designated key is less than the current key of the designated node
            System.out.println("ERROR: new key is smaller than current key ");
        }

        else {
            //ar[i] = key;
            ar.set(i, key); // java arraylists interpretation of a[i] = key. Note that they set function takes in 2 parameters: the designated index and the key value)
            while (i > 0 && ar.get(parent(i)) < ar.get(i)) { // arrays and arraylists start at index 0!
                //exchange A[i] with A[parent(i)]

                // Testing/Debugging purposes
                /*System.out.println("The value of A[i] before the exchange: " + ar.get(i));
                System.out.println("The index of A[i] is before the exchange: " + ar.indexOf(ar.get(i)));

                System.out.println("The value of A[parent(i)] before the exchange: " + ar.get(parent(i)));
                System.out.println("The index of A[parent(i)] before the exchange: " + ar.indexOf(ar.get(parent(i))));
                */

                Collections.swap(ar, i, parent(i)); // the collections library allows you to directly swap the values of A[i] (children) and A[parent(i)] (parent)

                // Testing/Debugging purposes
                /*System.out.println("The value of A[i] after the exchange: " + ar.get(i));
                System.out.println("The index of A[i] is after the exchange: " + ar.indexOf(ar.get(i)));

                System.out.println("The value of A[parent(i)] after the exchange: " + ar.get(parent(i)));
                System.out.println("The index of A[parent(i)] after the exchange: " + ar.indexOf(ar.get(parent(i))));
                */
                i = parent(i);
            } // end of while loop
            displayList(ar); // only display the heap if the new key is greater than the current key
        }
    }

    /**
     *
     * @param nodeIndex - the index of the node as an integer
     * @return - the parent node which is (nodeIndex - 1) / 2 because
     * both the left and right children shares only 1 parent
     */
    private static int parent(int nodeIndex) {
        return (int) (nodeIndex - 1) / 2; // note that the left and right child shares only 1 parent
    }

    // Case 2 - Maximum
    /**
     *
     * @param ar - the arraylist of integers that we will be getting the maximum value of the heap
     * @return - the max value, which is the root of the heap after building a max heap
     */
    public static int heapMaximum(ArrayList<Integer> ar) {
        int maxValue = ar.get(0);
        return maxValue;
    }

    /**
     *
     * @param ar - the arraylist of integers that we will be displaying the max heap
     */
    public static void displayList(ArrayList<Integer> ar) { // print arraylist function
        System.out.print("Outputted Max Heap: ");

        for (int j = 0; j < ar.size(); j++) {
            System.out.print(ar.get(j) + " ");
        }
        System.out.println();
    }

    // Case 3 - Extract Max
    /**
     *
     * @param ar - the arraylist of integers that we will be getting the max value as well as removing it from the heap
     * @return the max value of the heap
     */
    public static int heapExtractMax(ArrayList<Integer> ar) {

        int maxValue = Integer.MIN_VALUE; // when we handle an empty heap, we set the max value to negative infinity
        if (ar.size() < 1) { // if the heap is empty, then throw heap underflow error
            System.out.println("Error: Heap Underflow");
        }

        else if (ar.size() >= 1) { //if the size of the heap is one or higher, than it handles empty arrays by preventing the index out of bounds error
            maxValue = ar.get(0); // assign and store the max value to be the the root of the arraylist (heap). max = A[1]
            // Testing/Debugging purposes
            /*System.out.println("Max value is: " + maxValue);
            System.out.println("Beginning of arraylist before collections swapping is: " + ar.get(0));
            System.out.println("Last element of arraylist before collections swapping is : " + ar.get(ar.size() - 1));

            System.out.print("Prior to collections swapping: ");
            for (int i = 0; i < ar.size(); i++) {
                System.out.print(ar.get(i) + " ");
            }
            System.out.println(); */

            // note that if there is only 1 element or less in the heap, then the collections.swap would not have an effect
            Collections.swap(ar, 0, ar.size() - 1); // move the max value to the top of the heap: end of arraylist

            // Testing/Debugging purposes
            /*System.out.print("Post collections swapping: ");
            for (int j = 0; j < ar.size(); j++) {
                System.out.print(ar.get(j) + " ");
            }
            System.out.println();

            System.out.println("Beginning of arraylist post swapping is: " + ar.get(0));
            System.out.println("Last element of arraylist post swapping is: " + ar.get(ar.size() - 1));
            System.out.println("Swap successful");*/

            ar.remove(ar.size() - 1); // remove the max element from the heap by heap extract max
            maxHeapify(ar, 0); // call max heapify at the root but at index 0 because arrays and arraylists indices start at 0

            return maxValue; // returns the maxValue: ar.size() - 1 after the root is placed at the end of the heap
        }
        return maxValue; // returns negative infinity if the heap is empty
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); // string scanner

        // Because we noticed that the function insert (max heap insert from pg.164 added a node as negative infinity).
        ArrayList<Integer> ar = new ArrayList<Integer>(args.length); // COMMAND LINE TESTING

        while (ar.size() == 0) { // while the arraylist is empty due to the cause of the user trying to add a string, special character, or a phrase, validate the user input

            try {
                System.out.print("Input an array of integers separated by spaces: ");
                String regexPattern = " "; // we use the " " to split the numbers as well as to ignore the extra whitespacing
                String numbers = sc.nextLine(); // ask for user input an array of integers as strings
                String stringNumList[] = numbers.split(regexPattern);

                for (int i = 0; i < stringNumList.length; i++) { // iterate through the array and capture the parsed (integer values) into the arraylist
                    ar.add(Integer.parseInt(stringNumList[i])); // if the strings are actual numbers, then add them to the arraylist of integers
                }

                // Testing/Debugging Purposes
                //System.out.println("Arraylist items: " + ar);
                //System.out.println("Arraylist size: " + ar.size());
            }

            catch (NumberFormatException e){ // number format exception takes a string or any other form of nonintegers and tries to add it to an arraylists of integers, but nothing happens.
                // for example: if someone tries to put in oreo, < > {} or honey garlic siracha, then it does not go in the arraylist of integers
                // Testing/Debugging Purposes
                //System.out.println("number format exception caught successfully! ");
                //System.out.println("Arraylist items: " + ar);
                //System.out.println("Arraylist size: " + ar.size());
            }
        }

        /*System.out.print("Input an array of integers separated by spaces: ");
        String regexPattern = " "; // we use the " " to split the numbers as well as to ignore the extra whitespacing
        String numbers = sc.nextLine();
        String stringNumList[] = numbers.split(regexPattern);*/

       /*ArrayList<Integer> ar = new ArrayList<Integer>(args.length); // COMMAND LINE TESTING

        for (int i = 0; i < stringNumList.length; i++) { // iterate through the array and capture the parsed (integer values) into the arraylist
            ar.add(Integer.parseInt(stringNumList[i]));
        }*/

        // Testing to see if the arraylist is properly holding the values as the user inputs into a string array

        /*
        for(int x = 0; x < ar.size(); x++) {
            System.out.print("Actual ArrayList values before build max heap: " + ar.get(x));
        }

        System.out.println("Size of ArrayList is : "+ ar.size()); // test to see if numbers are actually in the arraylist
        */

        buildMaxHeap(ar); // we need to have a max heap prior reaching the switch case:
        displayList(ar);

        Scanner in = new Scanner(System.in); // scanner for choice selection for the switch case
        int option = -1; // set the choice as -1 for dummy data

        // switch case instead of the boring if (option == 1) {...}
        // for a switch case, if you do not break, IT WILL AUTOMATICALLY GO IN THE NEXT CASE!

        boolean keepGoing = true;

        while (keepGoing) { // while true, ...

            switch (option) {
                case 1: // insert
                    System.out.print("Input the integer you want inserted: ");
                    int numInsert = in.nextInt();
                    //System.out.println("numInsert: " + numInsert);
                    maxHeapInsert(ar, numInsert);
                    System.out.println("Choose from the following options: ");
                    displayMenu();
                    option = in.nextInt();
                    break;

                case 2: // maximum
                    System.out.println("Maximum value is: " + heapMaximum(ar));
                    System.out.println("Choose from the following options: ");
                    displayMenu();
                    option = in.nextInt();
                    break;

                case 3: // extract-max
                    System.out.println("Maximum value is: " + heapExtractMax(ar));
                    displayList(ar);
                    System.out.println("Choose from the following options: ");
                    displayMenu();
                    option = in.nextInt();
                    break;

                case 4: // increase-max
                    System.out.print("Input the index of the node you want to increase: ");
                    int nodeIndicie = in.nextInt();
                    //System.out.println("Node target: " + nodeIndicie);
                    int valueTarget = ar.get(nodeIndicie - 1); // because arrays and arraylists start at 0, you had to subtract 1 because if you don't, you are getting the value after the intended value
                    //System.out.println("Current Key Value: " + valueTarget);
                    System.out.print("Input the new value: ");
                    int replacementValue = in.nextInt();

                    // because arrays and arraylists start at 0, you had to subtract 1 because if you don't, you are getting the value
                    heapIncreaseKey(ar, nodeIndicie - 1, replacementValue);
                    System.out.println("Choose from the following options: ");
                    displayMenu();
                    option = in.nextInt();
                    break;

                case 5: // exit
                    keepGoing = false; // when we trigger the boolean to false when we have a while true loop, it stops the loop
                    break;

                default: // validates when the user inputs anything less than 1 or greater than 5
                    System.out.println("Choose from the following options: ");
                    displayMenu();
                    option = in.nextInt();

            } // end of switch case
        } // end of boolean flag
    }
}