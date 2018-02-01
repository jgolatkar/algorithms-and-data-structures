#!/usr/bin/python
# Insertion Sort in non-decreasing order

def insertionSort(array):
    for j in range(1,len(array)):
        key = array[j]
        i = j - 1

        while i >=0 and array[i] > key: # array[i] < key for non-increasing order
            array[i+1] = array[i]
            i = i - 1
        array[i+1] = key

    return array

print ("Enter a list of numbers to sort")
sortedArray = []
for i in range(5):
    a = int(input())
    sortedArray.append(a)

print("Sorted Array: " + str(insertionSort(sortedArray)))
