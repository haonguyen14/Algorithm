public class Merge {
	public static void main(String[] args) {
		int[] arr = new int[args.length];
		for(int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(args[i]);

		sort(arr);
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}


	/**
	 *	Iterative Merge Sort
	 */
	public static <T> void sort(int a[]) {
		for(int width = 1; width < (a.length); width *= 2) {
			int temp[] = new int[a.length];
			
			for(int i = 0; i < a.length; i += (2 * width))
				merge(a, i, i + width, i + (2 * width), temp);
			
			for(int i = 0; i < a.length; i++)
				a[i] = temp[i];
		}
	}


	private static <T> void merge(int arr[], int left, int right, int end, int temp[]) {
		int bI = left;
		int l = left;
		int r = right;

		while(l < arr.length && l < right && r < end) {
			if(r >= arr.length || arr[l] < arr[r])
				temp[bI++] = arr[l++];
			else
				temp[bI++] = arr[r++];
		}

		while(l < right && l < arr.length) temp[bI++] = arr[l++];
		while(r < end && r < arr.length) temp[bI++] = arr[r++];
	}
}
