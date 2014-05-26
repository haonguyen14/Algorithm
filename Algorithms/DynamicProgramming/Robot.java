public class Robot {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);

		System.out.println(walkDP(n, m));
	}


	public static int walk(int n, int m) {
		/* Edge Condition */
		if(n == 1 && m == 1)
			return 0;
		if(n == 1 || m == 1)
			return 1;

		int ret = 0;
		ret += walk(n, m - 1);	// walk right
		ret += walk(n - 1, m );	// walk right

		return ret;
	}


	public static int walkDP(int n, int m) {
		int[][] w = new int[n + 1][m + 1];
		
		/* Initialize */
		w[1][1] = 0;
		for(int i = 1; i <= m; i++)
			w[1][i] = 1;
		for(int i = 1; i <= n; i++)
			w[i][1] = 1;

		for(int i = 2; i <= n; i++)
			for(int j = 2; j <= m; j++)
				w[i][j] = w[i][j - 1] + w[i - 1][j];

		return w[n][m];
	}
}
