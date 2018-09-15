import java.util.Arrays;

public class MinHeap {
	int size = 0;
	int capacity = 10;

	int[] items = new int[capacity];

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

	private int parent(int index) {
		return items[getParentIndex(index)];
	}

	private void swap(int index1, int index2) {
		int item = items[index1];
		items[index1] = items[index2];
		items[index2] = item;
	}

	private void ensureCapacity() {
		if (capacity == size) {
			capacity *= capacity;
			items = Arrays.copyOf(items, capacity);
		}
	}

	public int peek() {
		if (size == 0)
			throw new IllegalStateException();
		return items[0];
	}

	public int poll() {
		if (size == 0)
			throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return item;
	}

	public void add(int item) {
		ensureCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}

	private void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && items[getParentIndex(index)] > items[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
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

}
