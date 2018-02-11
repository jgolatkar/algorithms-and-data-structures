package com.datastructures.linkedlist;

public class Node {
	Node next;
	Node prev;
	Integer data;
	
	public Node(Integer data) {
		this.data = data;
		next = null;
		prev = null;
	}
	
	public Node getNext() {
		return next;
	}
	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

	
}
