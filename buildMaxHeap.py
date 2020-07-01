import math

def left(i):
    return (2 * i) + 1

def right(i):
    return (2 * i) + 2

def buildMaxHeap(A):
    heapSize = len(A)
    print("heapsize is: ", heapSize)
    #print(heapSize // 2)

    for i in range(len(A) // 2, -1, -1):
        maxHeapify(A, i)
        #print(maxHeapify(A,i))
        
def maxHeapify(A, i):
    l = left(i)
    r = right(i)

    print("Left is: ", l)
    print("Right is: " , r)

    if l < len(A) and A[l] > A[i]:
        largest = l

    else:
        largest = i

    if r < len(A) and A[r] > A[largest]:
        largest = r

    if largest != i:
        temp = A[i]
        A[i] = A[largest]
        A[largest] = temp
        maxHeapify(A, largest) #recursive call maxHeapify
        print("Recursively calling maxHeapify on Node", str(largest), "\n")


def main():

    A = [4, 5, 1, 7, 3, 3, 8]

    print("A before: ", A)

    print("Processing Max Heapify")

    buildMaxHeap(A)

    print("Processed Max Heapify")

    print("A after: ", A)


main()

