import java.lang.reflect.Array;

/**
 * @Course: CECS 328
 * @Assignment: Lab Programming Assignment #2 - MergeSort
 * @authors: Meng Moua, Daniel Duong, Jesse Gudardo
 * @duedate: 3/1/20
 */

public class MergeSort
{
    /** a counter when a comparison is trigger */
    private static int count;

    /**
     * @param inputArray - the array of integers will going through merge sorting
     * @param left - the left index of the array
     * @param midPoint - the middle index of the array (floored)
     * @param right - the right index of the array
     */
    private static void merge(int inputArray[], int left, int midPoint, int right)
    {
        int leftSubArraySize = midPoint - left + 1; // subtract the size of the left array from the midpoint and add 1
        int rightSubArraySize = right - midPoint; // subtract the size of the midpoint from the size of the right subarray

        int[] leftArray = new int[leftSubArraySize + 1]; // temp left array
        int[] rightArray = new int[rightSubArraySize + 1]; // temp right array

        for (int i = 0; i < leftSubArraySize; i++) { // copy data into left subarray
            leftArray[i] = inputArray[left + i]; //put the data into sub arrays (-1 causes index outta bounds)
        }

        //if (leftSubArraySize >= 0) System.arraycopy(inputArray, left, leftArray, 0, leftSubArraySize);

        for (int j = 0; j < rightSubArraySize; j++) { // copy data into right subarray
            rightArray[j] = inputArray[midPoint + j + 1]; // put the data into sub arrays
        }

        leftArray[leftSubArraySize] = Integer.MAX_VALUE; // representation of infinity (arbitrarily starting point)
        rightArray[rightSubArraySize] = Integer.MAX_VALUE; // representation of infinity (arbitrarily starting point)

        int index = left;
        int i, j;
        for(i = 0, j = 0; i < leftSubArraySize && j < rightSubArraySize;) {

            if (leftArray[i] <= rightArray[j])
            {
                inputArray[index] = leftArray[i];
                i += 1;
                count++;
            }
            else
            {
                inputArray[index] = rightArray[j];
                j += 1;
                count++;
            }
            index++;
        }

        // any highest remaining elements from left side will
        // automatic recursive add into the array set
        while (i < leftSubArraySize) {
            inputArray[index] = leftArray[i];
            i++;
            index++;
        }
    }

    /**
     *
     * @param inputArray - the array of integers being passed in to sort all the merged subarrays
     * @param start - the left index of the array
     * @param end - the right index of the array
     */
    private static void mergeSort(int inputArray[], int start, int end)
    {
        int midPoint;
        if (start < end) { // you compare by the indicies so that way, you do not get an IndexOutOfBounds  //0 < 6, yes

            midPoint = (start + end) / 2;    //(0 + 6) / 2 = 3 floor

            mergeSort(inputArray, start, midPoint); // recursive splitting the first half of the array   //left = 0, midPoint = 3

            mergeSort(inputArray, midPoint + 1, end); // recursively splitting the second half of the array   //midPoint = 4, right = 6
            merge(inputArray, start, midPoint, end); // merge all the sorted subArrays //left = 0, midPoint = 3, right = 6
        }
    }

    public static void main (String [] args)
    {
        int[] intSet = new int[args.length];
        //System.out.println(args.length);
        int index = 0;
        for (String s : args)
        {
            intSet[index] = Integer.parseInt(s);
            index++;
        }

        //Test cases
        //int[] intSet = {4, 5, 1, 7, 3, 3, 8};
        //int[] intSet = new int []{1, 2, 1};
        //int[] intSet = new int []{1};
        //int[] intSet = new int []{5, 5, 5, 5};
        //int[] intSet = new int []{1, 2, 3, 4, 5, 6, 7};
        System.out.println("Unsorted Array");
        display(intSet);

        //MergeSort start here
        mergeSort(intSet, 0, intSet.length-1); // causes index outta bounds

        System.out.println("Sorted array");
        display(intSet);

        System.out.println("Number of comparisons: " + count);
    }

    /**
     * A function to display an array set
     * @param inputSet set of array
     */
    static void display(int[] inputSet)
    {
        int end = inputSet.length - 1;
        int z = 0;
        for (int i : inputSet)
        {
            if (z != end)
                System.out.print(i + " ");
            else
                System.out.print(i);
            z++;
        }
        System.out.println("\n");
    }
}