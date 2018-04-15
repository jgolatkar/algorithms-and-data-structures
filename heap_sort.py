# Heap Sort using Max-Heap


# heapify array subtree rooted at index i
def max_heapify(A, n, i):
	l = 2 * i + 1
	r = 2 * i + 2
	
	lg = i
	
	# check if left child exist and is greater than root
	if l < n and A[l] > A[lg]:
		lg = l
		
	# check if right child exist and is greater than root
	if r < n and A[r] > A[lg]:
		lg = r
	
	# if root is not he largest in subtree, swap the 
	# largest child with root
	if lg != i:
		A[i],A[lg] = A[lg],A[i]
		max_heapify(A, n, lg) # recursive call to heapify rest of the subtrees
		

# build max-heap
def build_heap(A, n):

	for i in range(n-1, -1, -1):
		print(i)
		max_heapify(A, n, i)

		
def heap_sort(A):
	n = len(A)
	build_heap(A,n)
	for i in range(n-1,0,-1):
		A[0],A[i] = A[i],A[0]
		max_heapify(A,i,0)
	return A
	
A = [12, 11, 13, 5, 6, 7]

print(heap_sort(A))