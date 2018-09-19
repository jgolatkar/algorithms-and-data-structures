import java.util.Arrays;

public class Vector {

	int size;
	Integer[] container;
	int capacity;

	public Vector(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.container = new Integer[capacity];
	}

	public Integer elemAtRank(int rank) {
		return container[rank];
	}

	public void insertAtRank(Integer o, int r) {
		ensureCapacity();
		if (container[r] == null) {
			container[r] = o;
		} else {
			int i = capacity - 1;
			for (; i > r; i--) {
				container[i] = container[i - 1];
			}
			container[i] = o;
		}
		size++;
	}

	public Integer removeAtRank(int r) {
		int tmp = container[r];
		if (!isEmpty()) {
			for (int i = r + 1; i < capacity; i++) {
				container[i - 1] = container[i];
			}
		}
		size--;
		return tmp;
	}

	private boolean isEmpty() {

		return size == 0;
	}

	private void ensureCapacity() {
		if (size == capacity - 1) {
			capacity = capacity * 2;
			container = Arrays.copyOf(container, capacity);
		}
	}

	public void printVector() {
		System.out.println(Arrays.toString(container));
	}

}
