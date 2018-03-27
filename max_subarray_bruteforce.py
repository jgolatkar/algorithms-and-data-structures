# Find maximum sum of contiguous sub-array
# Brute Force Solution - O(n^2)

import sys as sys
def find_max_subarray(A,low,high):
	l_i = low
	r_i = high - 1
	
	sum = 0
	max_sum = -sys.maxsize - 1
	
	for i in range(high - 1):
		sum += A[i]
		if sum > max_sum:
			max_sum = sum
			l_i = i
			r_i = i
		for j in range (i+1 , high):
			sum += A[j]
			if sum > max_sum:
				max_sum = sum
				l_i = i
				r_i = j
		sum = 0
	print('left_index: '+str(l_i)+' right_index: '+str(r_i))
	print('max_sum: '+str(max_sum))

A = [3,-2,5]	
find_max_subarray(A,0,len(A))

"""
Output:
left_index: 0 right_index: 2 
max_sum: 6                                                
"""