/*
 *	Maximum Subarray using Divide-and-Conquer
 */
public class MaximumSubarray {
	public static final int LOW = 0;
	public static final int HIGH = 1;
	public static final int SUM = 2;

	
	public static void main(String[] args) {
		int[] arr = new int[args.length];
		for(int i = 0; i < args.length; i++)
			arr[i] = Integer.parseInt(args[i]);
		
		int[] subarray = maxSubarray(arr, 0, arr.length - 1);
		System.out.println( String.format("Sum([%d, %d]) = %d", subarray[LOW], subarray[HIGH], subarray[SUM]) );
	}


	public static int[] maxSubarray(int[] arr, int low, int high) {
		/* Edge Condition */
		if(low == high)
			return new int[] {low, high, arr[low]};

		int mid = (low + high) / 2;
		
		int[] left = maxSubarray(arr, low, mid);
		int[] right = maxSubarray(arr, mid + 1, high);
		int[] cross = maxCross(arr, low, mid, high);

		int[] ret = left;
		if(ret[SUM] < right[SUM])
			ret = rightear

		if(ret[SUM] < cross[SUM])
			ret = cross;

		return ret;
	}


	public static int[] maxCross(int[] arr, int low, int mid, int high) {
		/* arr[low ... mid] */
		int leftM = Integer.MIN_VALUE;
		int leftI = -1;

		int sum = 0;
		for(int i = mid; i >= low; i--) {
			sum += arr[i];
			if(sum > leftM) {
				leftI = i;
				leftM = sum;
			}
		}
		

		/* arr[mid + 1 ... high] */
		int rightM = Integer.MIN_VALUE;
		int rightI = -1;

		sum = 0;
		for(int i = mid + 1; i <= high; i++) {
			sum += arr[i];
			if(sum > rightM) {
				rightI = i;
				rightM = sum;
			}
		}

		return new int[] {leftI, rightI, leftM + rightM};
	}
}
