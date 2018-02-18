package com.datastructures.hashtable;

import java.util.Arrays;

/**
 * @author jitesh.golatkar
 *
 */

public class HashTable {

	int size;
	Integer[] table;
	int count;

	// initialize hashtable
	public HashTable(int size) {
		super();
		this.size = size;
		table = new Integer[size];
		Arrays.fill(table, null);
		count = 0;
	}

	// hash function to calculate hash value of bucket
	public int hash(Integer key) {
		int hash = key % (size - 1);
		return hash;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	/**
	 * PUT operation - Inserting key into Hash Table If the slot is pre-occupied,
	 * try next slot till empty slot is found
	 * 
	 * @param key
	 */
	public void put(Integer key) {
		if (!isFull()) {
			int index = hash(key);
			while (table[index] != null) {
				++index;
				System.out.println("Collision at " + (index - 1) + " for " + key + ".Next Try at " + index);
				index %= size;
			}
			System.out.println("Hashed index = " + index + " for value " + key);
			table[index] = key;
			count++;
		} else {
			System.out.println("Table is Full.");
		}
	}

	/**
	 * GET Operation - returns the element corresponding to the given key This
	 * function first calculates hash for given key and looks up the element at hash
	 * index in the hashtable till the element or null is found.
	 * 
	 * @param key
	 * @return
	 */
	public Integer get(Integer key) {
		int index = hash(key);

		while (table[index] != null) {
			System.out.println("Searching at index " + index);
			if (table[index] == key) {
				System.out.println(key + " found at index " + index);
				return table[index];
			}
			index++;
			index %= size;
		}
		System.out.println(key + " not present in the table.");
		return null;

	}

	// checks if table is full
	public boolean isFull() {
		return count == size;
	}
}
