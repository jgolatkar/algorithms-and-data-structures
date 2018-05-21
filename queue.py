#!/usr/bin/env python

# Queue implementation using array

head = -1
tail = -1

queue = []

def enqueue(data):
	global head,tail
	if head == -1 and tail == -1:
		head += 1
		tail += 1
	else:
		tail += 1
	queue.append(data)
	print(str(data)+' is added to the queue.')
	print('size: '+str(len(queue)))

def dequeue():
	global head,tail
	
	if head != -1 and tail != -1:
		tmp = queue[head]
		queue[head] = -1
		if head == tail:
			head,tail = -1,-1
		else:
			head += 1
		print('item removed: '+str(tmp))
	else:
 		print(-1)

def peek():
	global head

	if head != -1:
		return queue[head]
	else:
		return -1

enqueue(6)
enqueue(8)
enqueue(14)
enqueue(18)
enqueue(22)

print(queue)

dequeue()
dequeue()
dequeue()
dequeue()
dequeue()
print(queue)

print('peek: '+str(peek()))


