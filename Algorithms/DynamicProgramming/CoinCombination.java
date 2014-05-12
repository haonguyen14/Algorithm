import java.util.LinkedList;


/*
 *	The number of combinations of integers that make up an integer K
 */
public class CoinCombination {
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		LinkedList<Integer> coins = new LinkedList<Integer>();
		for(int i = 1; i < args.length; i++)
			coins.addLast(Integer.parseInt(args[i]));

		System.out.println(combination(k, coins));
	}

	
	/*
	 *	Recursive Version
	 */
	public static long combination(int k, LinkedList<Integer> coins) {
		/* Edge Condition */
		if(k < 0)
			return 0;
		if(k == 0)
			return 1;
		if(coins.size() == 0)
			return 0;

		long ret = 0;
		// Protect the LinkedList from being changed
		LinkedList<Integer> temp = new LinkedList<Integer>(coins);
		for(Integer c : coins) {
			ret += combination(k - c, temp);
			temp.remove();
		}

		return ret;
	}
	
	
	/*
	 *	Simpler Version of the Recursive Version.
	 *	Note: Read this code to understand the algorithm
	 */
	public static long combination(int k, int a, int b, int c, int d) {
		/* Edge Condition */
		if(k < 0)
			return 0;
		if(k == 0)
			return 1;
		if(a == 0 && b == 0 && c == 0 && d == 0)
			return 0;
		
		long ret = ((a == 0) ? 0 : combination(k - a, a, b, c, d)) +
			   ((b == 0) ? 0 : combination(k - b, 0, b, c, d)) +
			   ((c == 0) ? 0 : combination(k - c, 0, 0, c, d)) +
			   ((d == 0) ? 0 : combination(k - d, 0, 0, 0, d)) ;
		
		System.out.println(String.format("c(%d, %d, %d, %d, %d) = %d", k, a, b, c, d, ret));
		return ret;
	}


}
