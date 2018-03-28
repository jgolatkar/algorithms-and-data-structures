# Find maximum sum of contiguous sub-array
# Divide and Conquer Solution - O(nlogn)

import sys as sys

def max_subarray(A, low, high):
	if high == low:
		return A[low]
	else:
		mid = (high + low)//2
		max_left = max_subarray(A, low, mid)
		max_right = max_subarray(A, mid + 1, high)
		max_cross = max_cross_subarray(A, low, mid, high)
		return max(max_left, max_cross, max_right)
	

def max_cross_subarray(A, low, mid, high):
	left_sum = -sys.maxsize - 1
	sum = 0
	max_left = 0
	max_right = 0
	for i in range (mid, low-1,-1):
		sum += A[i]
		if sum > left_sum:
			left_sum = sum
	right_sum = -sys.maxsize - 1
	sum = 0
	for j in range (mid+1, high):
		sum += A[j]
		if sum > right_sum:
			right_sum = sum
	return (left_sum + right_sum)
	
A = [ -2, -3, 4, -1, -2, 1, 5, -3]
max_sum = max_subarray(A,0,len(A) - 1)
print('max_sum: '+str(max_sum))

"""
Output:
max_sum: 7
"""