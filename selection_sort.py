#!/usr/bin/env python
print("enter numbers to sort")
nums = [int(x) for x in input().strip().split(" ")]

def find_min_and_swap(i):
    min = nums[i]
    minIndex = i
    for j in range(i+1, len(nums)):
        if nums[j] < min:
            min = nums[j]
            minIndex = j
    nums[minIndex] = nums[i]
    nums[i] = min

for i in range(len(nums)-1):
    find_min_and_swap(i)

print("sorted list: " + str(nums))
