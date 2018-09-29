import java.util.Arrays;

public class CountingSort {

	public int[] sort(int[] arr) {
		int range = max(arr) + 1;
		int[] count = new int[range];

		int[] output = new int[arr.length];

		// count the occurrences
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}

		// take cumulative sum
		for (int i = 1; i < count.length; i++) {
			count[i] = count[i] + count[i - 1];
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			count[arr[i]]--;
			output[count[arr[i]]] = arr[i];
		}

		return output;
	}

	private int max(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		CountingSort c = new CountingSort();
		int[] a = { 25, 6, 15, 12, 8, 3, 11 };
		System.out.println(Arrays.toString(c.sort(a)));
	}

}
