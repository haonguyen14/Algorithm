/**
 *	Contiguous elements in an array whose sum is k
 */

public class ContiguousSum {
	public static void main(String[] args) {
		int[] arr = new int[ args.length - 1 ];
		for(int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(args[i]);

		int k = Integer.parseInt(args[args.length - 1]);
		int[] result = find(arr, k);

		System.out.println("[ " + result[0] + ", " + result[1] + " ]");
	}


	public static int[] find(int[] arr, int k) {
		int start = 0;
		int end = 0;
		int curr = k - arr[ end ];


		while(curr != 0 && ++end < arr.length) {
			if(curr < arr[ end ])
				while(start < end && curr < arr[ end ])
					curr = curr + arr[ start++ ];

			curr = curr - arr[ end ];
		}


		return new int[] {start, end};
	}
}
