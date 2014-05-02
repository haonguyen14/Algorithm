class LinearPartition
{
	public static void main(String[] args)
	{
		int[] a = new int[args.length];
		a[0] = 0;
		for(int i = 1; i < a.length; i++)
			a[i] = Integer.parseInt(args[i - 1]);

		int k = Integer.parseInt(args[args.length - 1]);
		init(a, args.length - 1, k);
		getCost(a, args.length - 1, k);

		/*//--------------- Debugging -------------------------------------------------------------
		for(int i = 0; i < cost.length; i++)
			for(int j = 0; j < cost[i].length; j++)
				System.out.print(cost[i][j] + ((j == cost[i].length - 1) ? "\n" : " "));

		for(int i = 0; i < sep.length; i++)
			for(int j = 0; j < sep[i].length; j++)
				System.out.print(sep[i][j] + ((j == sep[i].length - 1) ? "\n" : " "));
		//---------------------------------------------------------------------------------------*/
		
		printPartition(a, args.length - 1, k);
		System.out.println("");
	}
	
	public static int[][] cost;
	public static int[][] sep;
	public static int[] sum;

	/*
	 *	k = number of partitions, literally
	 */
	public static void init(int[] a, int n, int k)
	{	
		//-------------- initialize sum array -------------------
		sum = new int[n + 1];
		sum[0] = 0;
		for(int i = 1; i < n + 1; i++)
			sum[i] = sum[i - 1] + a[i]; 
		//-------------------------------------------------------

		//------------- initialize separator array --------------
		sep = new int[k + 1][n + 1];
		for(int i = 0; i < sep.length; i++)
			for(int j = 0; j < sep[i].length; j++)
				sep[i][j] = -1;
		//-------------------------------------------------------

		//------------- initialize cost table -------------------
		cost = new int[k + 1][n + 1];
		for(int i = 0; i < k + 1; i++)
		{
			for(int j = 0; j < n + 1; j++)
			{
				if(i == 1)
				{
					cost[i][j] = sum[j];
				}
				else
				{
					if(j == 1)
						cost[i][j] = sum[1];
					else
						cost[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		//-------------------------------------------------------

	}

	public static int getCost(int[] a, int n, int k)
	{
		if(k == 1 || n == 1)
			return cost[k][n];

		int currentCost = cost[k][n];
		for(int i = 1; i < n; i++)
		{
			int left = getCost(a, i, k - 1);
			int cost = (left > sum[n] - sum[i]) ? left : (sum[n] - sum[i]);
			
			if(cost < currentCost)
			{
				currentCost = cost;
				sep[k][n] = i;
			}
		}

		cost[k][n] = currentCost;
		return currentCost;
	}

	public static void printPartition(int[] a, int n, int k)
	{
		if(k == 1)
		{
			for(int i = 1; i <= n; i++)
				System.out.print(a[i] + " ");
			System.out.print("| ");
		}
		else
		{
			printPartition(a, sep[k][n], k - 1);
			for(int i = sep[k][n] + 1; i <= n; i++)
				System.out.print(a[i] + " ");
			System.out.print("| ");
		}
	}
}
