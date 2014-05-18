public class Counting {
	public static void main(String[] args) {
		int[] arr = new int[args.length - 1];
		for(int i = 0; i < args.length - 1; i++)
			arr[i] = Integer.parseInt(args[i]);

		int n = Integer.parseInt(args[args.length - 1]);
	
		int[] sorted = sort(arr, n);
		for(int i = 0; i < sorted.length; i++)
			System.out.print(sorted[i] + " ");
		System.out.println();
	}

	public static int[] sort(int[] arr, int n) {
		int[] ret = new int[arr.length];
		int[] c = new int[n + 1];

		// Initialize c (couting) array
		for(int i = 0; i < c.length; i++)
			c[i] = 0;

		// Count
		for(int i = 0; i < arr.length; i++)
			c[arr[i]]++;

		for(int i = 1; i < c.length; i++)
			c[i] += c[i - 1];

		// Populate ret (resulting) array
		// Traversing downward to guarantee stability
		for(int i = arr.length - 1; i >= 0; i--) {
			ret[ c[ arr[i] ] - 1 ] = arr[i];
			c[ arr[i] ]--;
		}

		return ret;
	}
}
