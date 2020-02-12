def linearSearch(array, target):

    #print("The target is a ", type(target))
    #print("The array is a ", type(array))

    found = False

    for position in range(len(array)):
        if array[position] == target:
            found = True
            return target, " found at position", position

    if found == False:
        return target, " not found"
        

def main():
    array = [1, 13, 4, 9, 6]
    print(linearSearch(array, 101))
    print(linearSearch(array, 13))

main()
