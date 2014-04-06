import java.util.Random;

/**
 *	Find the maximum sum of an array's subsequence
 *	Constrain:
 *		The subsequence's elements must not be contiguous within the array
 */

public class MaxSubsequenceSum {
	public static void main(String[] args) {
		int[] arr = new int[Integer.parseInt(args[0])];

		Random rand = new Random();
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(1000);
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		System.out.println(maxSum(arr));
	}

	
	/**
	 *	Recursive Version
	 */
	public static int maxSum(int[] arr, int right) {		
		if(right == 0)
			return arr[right];
		if(right == 1)
			return max(arr[0], arr[right]);

		return max(maxSum(arr, right - 1), arr[right] + maxSum(arr, right - 2));
	}


	/**
	 *	Dynamic Programming Version
	 */
	public static int maxSum(int[] arr) {
		if(arr.length == 1)
			return arr[0];

		int[] sums = new int[arr.length];
		sums[0] = arr[0];
		sums[1] = max(arr[0], arr[1]);

		for(int i = 2; i < arr.length; i++) {
			sums[i] = max(sums[i - 1], sums[i - 2] + arr[i]);
		}

		return sums[sums.length - 1];
	}


	private static int max(int a, int b) {
		return a > b ? a : b;
	}
}
