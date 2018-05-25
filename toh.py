#!/usr/bin/env python

# tower of hanoi

def move(n,frm,to,aux):
	if n == 1:
		print('moving disc '+str(n)+' from '+frm+' to '+to)
	else:

		move(n-1,frm,aux,to)
		print('moving disc '+str(n)+' from '+frm+' to '+to)
		move(n-1,aux,to,frm)
	

move(3,'A','C','B')		

"""
Output:

moving disc 1 from A to C
moving disc 2 from A to B
moving disc 1 from C to B
moving disc 3 from A to C
moving disc 1 from B to A
moving disc 2 from B to C
moving disc 1 from A to C

"""
