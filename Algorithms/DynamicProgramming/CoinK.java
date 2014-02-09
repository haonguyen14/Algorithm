import java.util.LinkedList;


/**
 *	Given a coin array, find a minimum number of coins that make up a sum K.
 */


public class CoinK {
	public static void main(String[] args) {
		int[] coins = new int[args.length - 1];
		for(int i = 0; i < coins.length; i++)
			coins[i] = Integer.parseInt(args[i]);

		int k = Integer.parseInt(args[args.length - 1]);
	}
	
	/*
	 *	Naive Implementation with Recursion
	 */
	 public static int count(int[] coins, int k) {
		/* Edge Condition */
		if(k <= 0)
			return 0;

		int min = Integer.MAX_VALUE;
		for(int i = 0; i < coins.length; i++) {
			int newVal =  count(coins, k - coins[i]) + 1;
			min = newVal < min ? newVal : min;
		}

		return min;
	 }


	 /*
	  *	Dynamic Programming Solution
	  */
	  public static int countDP(int[] coins, int k) {
		int[] cache = new int[k + 1];
		for(int i = 0; i < cache.length; i++)
			cache[i] = Integer.MAX_VALUE;
		cache[0] = 0;

		
		for(int i = 1; i <= k; i++) {
			for(int j = 0; j < coins.length; j++) {
				if(i - coins[j] >= 0 && i - coins[j] < cache.length)
					cache[i] = cache[i] > cache[i - coins[j]] + 1 ? (cache[i - coins[j]]) + 1 : cache[i];
			}
		}

		return cache[k];
	  }
}
