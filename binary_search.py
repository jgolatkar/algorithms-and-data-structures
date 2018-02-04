#!/usr/bin/python
# Binary Search implementation - O(logn)

def binarySearch(a,start,end,num):
    low = start
    high = end
    mid = int((low+high)/2)
    if num == a[mid]:
        return mid
    elif num > a[mid]:
        low = mid
        high = end
        return binarySearch(a,low,high,num)
    else:
        low = start
        high = mid
        return binarySearch(a,low,high,num)


search_input = [3,8,10,15,21,40,50]
n = int(input('Enter number to search: '))
i = binarySearch(search_input,0,len(search_input),n)

print (str(n)+' is at index '+ str(i))

"""

O/P:
Enter number to search: 21
21 is at index 4

"""
