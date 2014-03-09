public class LCS {
	public static void main(String[] args) {
		String[] strA1 = args[0].split(",");
		String[] strA2 = args[1].split(",");

		int[] a1 = new int[strA1.length];
		for(int i = 0; i < strA1.length; i++)
			a1[i] = Integer.parseInt(strA1[i]);

		int[] a2 = new int[strA2.length];
		for(int i = 0; i < strA2.length; i++)
			a2[i] = Integer.parseInt(strA2[i]);


		System.out.println(lcsDP(a1, a2, true));
	}

	
	/**
	 *	Naive Recursive Implemenation
	 */
	public static int lcs(int[] a1, int m, int[] a2, int n) {
		if(m == 0 || n == 0)
			return 0;

		if(a1[m - 1] == a2[n - 1])
			return lcs(a1, m - 1, a2, n - 1) + 1;
	
		return max(lcs(a1, m - 1, a2, n), lcs(a1, m, a2, n - 1));
	}


	/**
	 *	Dynamic Progamming Implementation
	 */
	 public static int lcsDP(int[] a1, int[] a2, boolean debug) {
		int[][] lcs = new int[a1.length][a2.length];

		/* Preliminary Processing */
		lcs[0][0] = (a1[0] == a2[0]) ? 1 : 0;

		for(int i = 1; i < a2.length; i++)
			lcs[0][i] = (a1[0] == a2[i]) ? 1 : lcs[0][i - 1];
		for(int i = 1; i < a1.length; i++)
			lcs[i][0] = (a1[i] == a2[0]) ? 1 : lcs[i - 1][0];


		/* Dynamic Cache Building */
		for(int i = 1; i < a1.length; i++) {
			for(int j = 1; j < a2.length; j++) {
				lcs[i][j] = (a1[i] == a2[j]) ? (lcs[i-1][j-1] + 1)
								: max(lcs[i-1][j], lcs[i][j-1]);
			}
		}


		/* Debugging */
		if(debug) {
			for(int i = 0; i < a1.length; i++) {
				for(int j = 0; j < a2.length; j++)
					System.out.print(lcs[i][j] + " ");
				System.out.println();
			}
		}

		return lcs[a1.length - 1][a2.length - 1];
	 }


	/**
	 *	Helper Functions
	 */
	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}
}
