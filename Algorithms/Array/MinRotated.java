public class MinRotated {
	public static void main(String[] args) {
		int[] arr = new int[args.length];
		for(int i = 0; i < args.length; i++)
			arr[i] = Integer.parseInt(args[i]);
		System.out.println(getMin(arr));	
	}

	public static int getMin(int[] arr) {
		if(arr.length < 1) return -1;

		int xIdx = 0;
		int yIdx = arr.length - 1;
		while(xIdx != yIdx) {
			int mid = Math.abs(xIdx - yIdx) == 1 ? 
								getSmallerIndex(arr, xIdx, yIdx) : 
								(xIdx + yIdx) / 2; 
			if(arr[xIdx] < arr[yIdx]) yIdx = mid;
			else xIdx = mid;
		}

		return xIdx;
	}	

	public static int getSmallerIndex(int[] arr, int x, int y) {
		return arr[x] > arr[y] ? y : x;
	}
}
