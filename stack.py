#!/usr/bin/env python

# Stack implementation using array

top = -1
stack = []

def push(data):
	global top
	top+=1
	stack.append(data)
	print(str(data)+' is pushed to the stack.')
	print('size: '+str(len(stack)))

def pop():
	global top
	if top != -1:
		tmp = stack[top]
		del stack[top]
		top-=1
		print('item popped: '+str(tmp))
	else:
		print(-1)

def peek():
	global top
	if top != -1:
		return stack[top]
	else:
		return -1

push(9)
push(18)
push(20)
push(7)
push(12)

print(stack)

pop()
pop()
pop()

print(stack)

print('peek: '+str(peek()))
		
	
