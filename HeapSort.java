import java.util.Arrays;

public class HeapSort {
	int size;
	int capacity;
	int[] items;

	public HeapSort(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		this.items = new int[capacity];
	}

	private int getLeftChildIndex(int index) {
		return (2 * index + 1);
	}

	private int getRightChildIndex(int index) {
		return (2 * index + 2);
	}

	private int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}

	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}

	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	private int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}

	private int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}

	private void swap(int index1, int index2) {
		int item = items[index1];
		items[index1] = items[index2];
		items[index2] = item;
	}

	private void ensureCapacity() {
		if (capacity == size) {
			capacity *= 2;
			items = Arrays.copyOf(items, capacity);
		}
	}

	public void insertItem(int k) {
		ensureCapacity();
		items[size] = k;
		size++;
		heapifyUp();
	}

	private void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && items[getParentIndex(index)] > items[index]) {
			swap(getParentIndex(index), index);
		}

	}

	public int removeMin() {
		if (size == 0) {
			throw new IllegalStateException();
		}
		int item = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return item;

	}

	private void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallChildIndex = getRightChildIndex(index);

			}
			if (items[index] < items[smallChildIndex]) {
				break;
			}
			swap(smallChildIndex, index);
			index = smallChildIndex;
		}

	}

	public int[] sort(int[] a) {
		for (int i : a) {
			insertItem(i);
		}
		for (int i = 0; i < a.length; i++) {
			a[i] = removeMin();
		}

		return a;
	}

}
