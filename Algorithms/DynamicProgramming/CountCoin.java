import java.util.ArrayList;

public class CountCoin {
	public static void main(String[] args) {
		int[] coins = new int[args.length - 1];
		for(int i = 0; i < coins.length; i++)
			coins[i] = Integer.parseInt(args[i]);

		int k = Integer.parseInt(args[args.length - 1]);

		System.out.println(count(coins, coins.length - 1, k));
	}


	/**
	 *	Naive Implementation
	 *	Repeatition Avoidance
	 */
	public static long count(int[] coins, int m, int k) {
		/* Edge Condition */
		if(k == 0)
			return 1;
		if(m < 0)
			return 0;
		if(k < 0)
			return 0;

		// count with at least 1 coins[m] + count with no coins[m] at all
		return count(coins, m - 1, k) + count(coins, m, k - coins[m]);
	}
}
