/*
 *	Select The Kth Smallest Element
 */


public class Selection {
	public static int select(int[] arr, int k, int left, int right) {
		/* Edge Condition */
		if(left > right)
			return -1;

		int pos = partition(arr, left, right, (left + right) / 2);
		if(k < pos) {
			return select(arr, k, left, pos - 1);
		} else if(k > pos) {
			return select(arr, k, pos + 1, right);
		} else {
			return arr[pos];
		}
	}

	
	/*
	 *	Partition Technique from QuickSort (In-place)
	 */
	public static int partition(int[] arr, int left, int right, int pivot) {
		int swapPos = left;	

		swap(arr, pivot, right);
		for(int i = left; i < right - 1; i++) {
			if(arr[i] < arr[right])
				swap(arr, i, swapPos++);
		}
		swap(arr, right, swapPos);
	
		return swapPos;
	}


	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];

		arr[a] = arr[b];
		arr[b] = temp;
	}
}
