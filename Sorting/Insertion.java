public class Insertion {
	public static void sort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int j = i;

			while(j > 0 && arr[j] < arr[j - 1]) {
				swap(arr, j, j - 1);
				j--;
			}
		}
	}


	private static void swap(int[] arr, int a, int b) {
		int temp = arr[i];

		arr[i] = arr[j];
		arr[j] = temp;
	}
}
