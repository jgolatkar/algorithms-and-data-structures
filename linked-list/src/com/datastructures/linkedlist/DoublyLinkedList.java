package com.datastructures.linkedlist;

import java.util.Arrays;

/**
 * Implementation of Doubly Linked List
 * 
 * @author jitesh.golatkar
 *
 */
public class DoublyLinkedList {

	Node head;
	Node tail;
	int count;

	public DoublyLinkedList() {
		head = null;
		tail = null;
		count = 0;
	}

	// add in order
	public void add(Integer data) {
		Node tmp = new Node(data);
		if (head == null) {
			head = tmp;
			tail = tmp;
		} else {
			Node current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			tmp.setPrev(current);
			current.setNext(tmp);
			tail = current.getNext();
		}
		count++;
	}

	// add at the beginning
	public void addFirst(Integer data) {
		Node tmp = new Node(data);
		Node current = head;
		current.setPrev(tmp);
		tmp.setNext(current);
		head = tmp;
		count++;
	}

	// add at i-th index
	public void add(Integer data, int index) {
		if (!isEmpty() && index >= 0) {
			Node tmp = new Node(data);
			Node current = head;
			if (index > 0) {
				for (int i = 1; i < index; i++) {
					current = current.getNext();
				}
				tmp.setPrev(current);
				tmp.setNext(current.getNext());
				current.getNext().setPrev(tmp);
				current.setNext(tmp);

				// if index is the end of list
				if (index == count) {
					tail = current.getNext();
				}
			} else {
				tmp.setNext(head);
				head = tmp;
				tail = tmp;
			}

			count++;
		}

	}

	// isEmpty
	public boolean isEmpty() {
		return head == null;
	}

	// get element at i-th index
	public Integer get(int index) {

		if (index < 0 || isEmpty()) {
			return null;
		}

		Node current = head;
		for (int i = 1; i <= index; i++) {

			current = current.getNext();
		}

		return current.getData();

	}

	// get previous element
	public Integer getPrevious(int index) {

		if (index < 0 || isEmpty()) {
			return null;
		}

		Node current = head;
		for (int i = 1; i <= index; i++) {
			if (current.getNext() != null)
				current = current.getNext();
			else
				return current.getData();
		}

		return current.getPrev().getData();

	}

	// get center element
	public Integer getCenter() {
		Node current = head;
		for (int i = 1; i <= count / 2; i++) {
			current = current.getNext();
		}
		return current.getData();

	}

	// size
	public int size() {
		return count;
	}

	// remove last element
	public void removeLast() {

		if (!isEmpty()) {
			tail = tail.getPrev();
			tail.setNext(null);
			count--;
		}

	}

	// remove first element
	public void removeFirst() {
		if (!isEmpty()) {
			head = head.getNext();
			count--;
		}
	}

	// remove element at i-th index
	public void remove(int index) {
		if (!isEmpty() || index > 0) {
			Node current = head;
			for (int i = 1; i < index; i++) {
				current = current.getNext();
			}
			current.setNext(current.getNext().getNext());
		} else {
			if (index == 0) {
				head = null;
			}
		}
		count--;
	}

	// remove odd elements
	public void removeOdd() {
		if (!isEmpty()) {
			Node current = head;
			Node tmp = null;
			while (current != null) {

				if (current.getData() % 2 != 0) {
					if (current.getPrev() == null) {
						current = current.getNext();
						current.setPrev(null);
						head = current;
					} else {
						tmp = current.getPrev();
						tmp.setNext(current.getNext());
						current = current.getNext();
						if (current != null) {
							current.setPrev(tmp);
						}
					}
					count--;
				} else {
					current = current.getNext();
				}
			}
		}
	}

	// reverse linked list
	public void reverse() {
		Node tmp = head;
		head = tail;
		tail = tmp;
		tail.setNext(null);
		Node current = head;
		while (current.getPrev() != null) {
			tmp = current.getNext();
			current.setNext(current.getPrev());
			current.setPrev(tmp);
			current = current.getNext();
		}

	}

	// delete linked list
	public void delete() {
		head = null;
	}

	@Override
	public String toString() {
		Integer[] data = new Integer[count];
		Node current = head;
		for (int i = 0; i < count; i++) {
			// System.out.println(current);
			data[i] = current.getData().intValue();
			current = current.getNext();
		}
		return "LinkedList [ " + Arrays.toString(data) + " count=" + count + " ]";
	}

	// display
	public void display() {
		System.out.println(this.toString());
	}

	// test functions
	public static void main(String[] args) {
		DoublyLinkedList l = new DoublyLinkedList();
		l.add(5);
		l.add(10);
		l.add(12);
		l.add(20);
		l.add(25);
		l.add(88, 2);
		l.addFirst(3);
		l.addFirst(15);
		System.out.println(l.tail);
		l.display();
		l.removeLast();
		l.display();
		System.out.println("Center: " + l.getCenter());
		l.reverse();
		l.display();
		l.removeOdd();
		l.display();
	}

}
