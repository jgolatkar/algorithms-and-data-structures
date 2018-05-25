package com.datastructures.hashtable;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashTable t = new HashTable(5);
		t.put(25);
		t.put(14);
		t.put(89);
		t.put(64);
		System.out.println(Arrays.toString(t.table));
		t.get(64);
	}

}
