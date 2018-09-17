import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Hash Table Implementation with Separate Chaining
 * 
 * @author Jitesh Golatkar
 *
 */
public class HashTable2 {

	int capacity;
	float load_factor = 0.00f;
	Object[] table = null;
	double size = 0;

	public double getSize() {
		return size;
	}

	public HashTable2(int capacity) {
		this.capacity = capacity;
		table = new Object[capacity];
	}

	private int hash(Integer key) {
		return (Math.abs(key) % capacity);
	}

	private void ensureCapacity() {
		if (load_factor >= 0.75f) {
			Object[] table2 = Arrays.copyOf(table, capacity);
			capacity = (int) (capacity * 0.75f) + capacity;
			load_factor = (float) (size / capacity);
			table = new Object[capacity];
			rehash(table2);
		}
	}

	private void rehash(Object[] table2) {
		size = 0;
		for (int i = 0; i < table2.length; i++) {
			if (table2[i] != null) {
				LinkedList<Integer> l = (LinkedList<Integer>) table2[i];
				Iterator<Integer> itr = l.iterator();
				while (itr.hasNext()) {
					Integer j = itr.next();
					insert(j);
				}
			}
		}
	}

	public void insert(Integer key) {
		int h = hash(key);
		ensureCapacity();
		if (table[h] == null) {
			LinkedList<Integer> l = new LinkedList<Integer>();
			l.add(key);
			table[h] = l;
		} else {
			LinkedList<Integer> l = (LinkedList<Integer>) table[h];
			l.add(key);
		}
		size++;
		calculateLoadFactor();

	}

	public Integer search(Integer key) {
		int h = hash(key);
		LinkedList<Integer> l = (LinkedList<Integer>) table[h];
		if (table[h] != null && !l.isEmpty()) {
			return h;
		}
		return null;
	}

	public boolean remove(Integer key) {
		int h = hash(key);
		boolean i = false;
		if (table[h] == null) {
			return i;
		} else {
			LinkedList<Integer> l = (LinkedList<Integer>) table[h];
			i = l.remove(key);
			if (i) {
				size--;
			}
			return i;
		}
	}

	private void calculateLoadFactor() {
		load_factor = (float) (size / capacity);
	}

	public void printTable() {

		for (int i = 0; i < table.length; i++) {
			System.out.println("Bucket: " + i + " -> " + table[i]);
		}
		System.out.println("\nSize: " + (int) size);
		System.out.println("Capacity: " + capacity);
	}

}
