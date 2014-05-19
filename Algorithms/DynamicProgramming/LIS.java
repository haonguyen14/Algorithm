public class LIS {
	public static void main(String[] args) {
		int[] arr = new int[args.length];
		for(int i = 0; i < args.length; i++)
			arr[i] = Integer.parseInt(args[i]);

		System.out.println( "LIS = " + fLIS(arr) );
	}

	public static int fLIS(int[] arr) {
		int[] lis = new int[arr.length];

		/* Initialize */
		lis[0] = -1;

		/* Compute LIS */
		for(int i = 1; i < arr.length; i++) {
			int max = -1; 
			for(int j = i - 1; j >= 0; j--) {

				/* Check for extensibility */
				if(arr[i] >= arr[j] && lis[j] >= max) {
					max = lis[j] + 1;				
				}
			}
			lis[i] = max;
		}

		/* Find max */
		int max = 0;
		for(int i = 1; i < lis.length; i++)
			max = (lis[max] < lis[i]) ? i : max;
		return lis[max] + 2;
	}
}
