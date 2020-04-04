def quickSort(array, p, r):

    print("p is: ", p)
    print("r is: ", r)

    if p < r:
        q = partition(array, p, r)
        print("q is : ", q)
        quickSort(array, p, q - 1)
        #print("1st quicksort recursive call: ")
        quickSort(array, q + 1, r)
        #print("2nd quicksort recursive call: ")

    elif p >= r: #if p is greater than or equal to r, quicksort has no effect
        print("quickSort(array,",str(p).strip(),",",str(r).strip(),")","did not have an effect")
        print()

    #strip removes the unused whitespaces 

def partition(array, p, r):
    x = array[r] #The book always select the pivot as the last element of the array
    print("Pivot is: ", x)
    i = p - 1
    counter = 0

    #for j = p to r - 1:
    for j in range(p, r):
        counter += 1
        print("array[j] is: ", array[j])
        print("comparing with the pivot: ", x)
        if array[j] <= x: #in the for loop
            i += 1
            #exchange A[i] with A[j]
            array[i], array[j] = array[j], array[i]
            print("Current Pivot's position is: ", array.index(x))
            print("After iterattion ", counter, " of partition", array)

    #exchange A[i + 1] with A[r]
    array[i + 1], array[r] = array[r], array[i + 1]
    print("Pivot's final postion is: ", array.index(x))
    print("After iteration ", counter, " of partition", array)
    print("i is :", i)
    print()
    return i + 1 #return i + 1


def main(): #Note, we are using a an list to sort elements and their indicies start at 0, not at 1 
    #array = [11, 5, 3, 7, 6, 5]
    array = [13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11]
    print("The array before the process of quicksort is: ", array)
    quickSort(array, 0, len(array) - 1)
    print("The array after quicksort is: ", array)

main()
    
        
