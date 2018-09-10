
public class SelectionSort {
	public int[] sort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			int min = a[i];
			int min_index = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < min) {
					min = a[j];
					min_index = j;
				}
			}
			a[min_index] = a[i];
			a[i] = min;
		}

		return a;
	}
}
