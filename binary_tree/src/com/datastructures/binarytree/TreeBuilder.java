package com.datastructures.binarytree;

public class TreeBuilder {

	public static void main(String[] args) {
		BinarySearchTree bt = new BinarySearchTree();
		bt.insert(23);
		bt.insert(12);
		bt.insert(29);
		bt.insert(5);
		bt.insert(17);
		bt.insert(26);
		bt.insert(32);

		bt.traverseInOrder();
		System.out.println("Largest Element: " + bt.largest());
		System.out.println("Smallest Element: " + bt.smallest());
		bt.delete(12);
		bt.traverseInOrder();

	}

}