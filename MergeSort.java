
public class MergeSort {

	public void mergeSort(int[] a, int[] temp, int leftStart, int rightEnd) {
		
		if(leftStart >= rightEnd)
			return;

		int mid = (leftStart + rightEnd) / 2;

		mergeSort(a, temp, leftStart, mid);
		mergeSort(a, temp, mid + 1, rightEnd);
		merge(a, temp, leftStart, rightEnd);

	}

	private void merge(int[] a, int[] temp, int leftStart, int rightEnd) {
		int leftEnd = (leftStart + rightEnd) / 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;

		int left = leftStart;
		int right = rightStart;
		int index = leftStart;

		while (left <= leftEnd && right <= rightEnd) {
			if (a[left] <= a[right]) {
				temp[index] = a[left];
				left++;
			} else {
				temp[index] = a[right];
				right++;
			}
			index++;
		}

		while (left <= leftEnd) {
			temp[index] = a[left];
			index++;
			left++;
		}

		while (right <= rightEnd) {
			temp[index] = a[right];
			index++;
			right++;
		}

		System.arraycopy(temp, leftStart, a, leftStart, size);
	}
}
