package com.datastructures.linkedlist;

import java.util.Arrays;

public class LinkedList {

	Node head;
	int count;

	public LinkedList() {
		head = null;
		count = 0;
	}

	// add in order
	public void add(Integer data) {
		Node tmp = new Node(data);

		if (head == null) {
			head = tmp;
		} else {
			Node current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(tmp);
		}
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
				tmp.setNext(current.getNext());
				current.setNext(tmp);
			} else {
				tmp.setNext(head);
				head = tmp;
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

	// size
	public int size() {
		return count;
	}

	// remove last element
	public void removeLast() {

		if (!isEmpty()) {
			Node current = head;
			while (current.getNext().getNext() != null) {
				current = current.getNext();
			}
			current.setNext(null);
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

	@Override
	public String toString() {
		Integer[] data = new Integer[count];
		Node current = head;
		for (int i = 0; i < count; i++) {
			data[i] = current.getData().intValue();
			current = current.getNext();
		}
		return "LinkedList [ " + Arrays.toString(data) + " count=" + count + " ]";
	}

	// display
	public void display() {
		System.out.println(this.toString());
	}

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.add(5);
		l.add(10);
		l.add(12);
		l.add(20);
		l.add(25);
		l.add(32, 3);
		l.removeLast();
		l.display();

	}

}
