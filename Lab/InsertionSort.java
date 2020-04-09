/**
 * Insertion Sort
 * Assignment: Lab Programming 1
 * Author:     Meng Moua, Daniel Duong, Jesse Guardado
 * DueDate:    2/9/2020
 */

/**
 * A class of Insertion Sort, sorting in ascending order
 */
class InsertionSort
{
    /**
     * Demo in Main
     */
    public static void main(String args[])
    {
        // checking for incoming input string from command line
        //UNCOMMENT/COMMENT THIS TO TESTING IN COMMAND LINE
        for (String s : args)
        {
            head = add(s);  // add each word into linkedList
        }

        // testing case
        //UNCOMMENT/COMMENT TO TESTING IN COMPILER
        /*head = add("apple");
        head = add("test");
        head = add("going");
        head = add("zebra");
        head = add("going");
        head = add("aardvark");*/

        // passing the head to insertionSort function to sort in alphabet order
        head = insertionSort(head);
        // display the list of the Linked List
        display(head);
    }

    /** head node of the linked list */
    private static Node head = null;

    /** Node class */
    public static class Node
    {
        Node previous;
        Node next;
        String phrase;
    }

    /**
     * A function to compare between two nodes in a sorted doubly linked list
     * @param beginning a node at the beginning
     * @param newNode a new node to compare
     * @return beginning node
     */
    private static Node compareNode(Node beginning, Node newNode)
    {
        Node current;

        // if the beginning node is empty
        if (beginning == null)
        {
            // beginning node become newNode
            beginning = newNode;
        }
        // else if the value of beginning node COMPARE to newNode is >= to 1
        else if (beginning.phrase.compareTo(newNode.phrase) >= 1)
        {
            // SWAPPING
            newNode.next = beginning;           // next node of (newNode) will contain the beginning node
            newNode.next.previous = newNode;    // swapping the value of newNode to previous of newNode.next
            beginning = newNode;                // also beginning node is holding newNode value
        }
        else
        {   //
            current = beginning;

            // while next node is not empty && the value of next node is less than the value of newNode by 0
            while (current.next != null && current.next.phrase.compareTo(newNode.phrase) < 0)
            {
                // current will hold its next value
                current = current.next;
            }

            newNode.next = current.next;    // next node of newNode will hold the next value of current node

            // if there is no next value in current node
            if (current.next != null)
            {
                // previous node of newNode will hold the value of newNode
                newNode.next.previous = newNode;
            }

            current.next = newNode;         // also, next node of current node will hold the value of newNode
            newNode.previous = current;     // then, previous node of newNode will hold the value of current node
        }
        return beginning;   // return the head
    }

    /**
     * A function doubly linked list to sort the head
     * @param head node of a head
     * @return head
     */
    private static Node insertionSort(Node head)
    {
        // sorted node with null initialization
        Node sorted = null;

        // assign the head to a current node
        Node current = head;
        while (current != null) // iteration until current node is empty
        {
            // get ready for next node
            Node next = current.next;

            // clear next and previous node to empty out
            current.next = null;
            current.previous = current.next;

            // now compare and sort both nodes (UPDATE linked list)
            sorted = compareNode(sorted, current);

            // Update current
            current = next;
        }

        // update head to hold sorted list
        head = sorted;
        // return back the head
        return head;
    }

    /**
     * A display function to print all elements from the linked list
     * @param head passing in the head Node
     */
    private static void display(Node head)
    {
        while (head != null)
        {
            if (head.next != null) // if next node still has an element
            {
                System.out.print(head.phrase + " ");    // print the phrase with a space
            }
            else
            {
                System.out.print(head.phrase);          // else, print just the phrase
            }
            head = head.next;   // increment to the next node
        }
    }

    /**
     * A function to add a phrase into a linked list
     * @param newPhrase a string phrase to be insert to sort
     * @return the head
     */
    private static Node add(String newPhrase)
    {
        // declare a temp node
        Node tempNode = new Node();

        // tempNode hold the phrase
        tempNode.phrase = newPhrase;

        // clear next and previous node to empty in tempNode
        tempNode.next = head;
        tempNode.previous = null;

        // if the head is not empty
        if (head != null)
        {
            head.previous = tempNode;   // previous node of the head will hold the value of tempNode
        }

        // move head to tempNode
        head = tempNode;

        return head;
    }
}