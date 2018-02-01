#!/usr/bin/python
# Quicksort implementation in a randomized way - O(nlogn)
import random

def quickSort(a,start,end):
	if start < end:
		pIndex = partition(a,start,end)
		quickSort(a,start,pIndex-1)
		quickSort(a,pIndex+1,end)
	
	
def partition(a,start,end):
	# Get the random element from array as pivot
	pivot = a[random.randint(start,end)]
	
	# Swap pivot with last element
	a[a.index(pivot)],a[end] = a[end], a[a.index(pivot)]
	pIndex = start
	
	for i in range(start,end):
		if a[i] <= pivot:
			a[pIndex],a[i] = a[i], a[pIndex]
			pIndex += 1
			
	a[end],a[pIndex] = a[pIndex],a[end]
	return pIndex
	

a = [5,6,8,4,55,34,73,22,105,19,10,80]
print ('Before Sort: '+ str(a))
quickSort(a,0,len(a)-1)
print ('After Sort: '+ str(a))