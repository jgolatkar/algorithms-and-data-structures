#!/usr/bin/python
# Mergesort implementation using divide and conquer

def mergeSort(a):
	n = len(a)
	if n > 1:
		mid = n/2
		left = a[0:mid]
		right = a[mid:n]
		mergeSort(left)
		mergeSort(right)
		merge(left,right,a)

def merge(left,right,a):
	nL = len(left)
	nR = len(right)
	i = 0
	j = 0
	k = 0
	
#to sort and merge the elements into original array
	while i < nL and j < nR:
		if left[i]<=right[j]:
			a[k] = left[i]
			i = i + 1
			k = k + 1
		else:
			a[k] = right[j]
			j = j + 1
			k = k + 1
	
#to merge leftover elements
	while i < nL:
		a[k] = left[i]
		i = i + 1
		k = k + 1
	
	while j < nR:
		a[k] = right[j]
		j = j + 1
		k = k + 1

			
a = [5,6,8,4,55,34,73,22,105,19,10,80]
print ('Before Sort: '+ str(a))
mergeSort(a)
print ('After Sort: '+ str(a))