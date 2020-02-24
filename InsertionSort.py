#This is the Insertion Sort Algorithm 1/23/20

def InsertionSort(array):
    
    j = 2 #By default rule of the algorithm, start at the 2nd position of the array.

    for j in range(1, len(array)):

        key = array[j] #The key is supposed to notify the next number you are looking at.

        i = j - 1 

        while i >= 0 and array[i] > key: #BEWARE, YOU ARE STILL IN THE WHILE LOOP.
            array[i + 1] = array[i]
            i = i - 1
            
            print("Processing Insertion Sort: ", array, "\n")

        print("The key is: ", key, "\n")

        array[i + 1] = key 


def main():

    #array = [5, 2, 4, 6, 1, 3]
    #array = [12, 11, 13, 5, 6]
    array = [31, 41, 59, 26, 41, 58]

    print("The array before is: ", array, "\n")

    InsertionSort(array)

    print("Post Insertion Sort: ", array, "\n")


main()
