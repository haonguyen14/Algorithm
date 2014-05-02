/*
 *	Range Maximum Query
 */

public class RMQ
{
	public static void main(String[] args)
	{
		int[] arr = new int[args.length];
		for(int i = 0; i < args.length; i++)
			arr[i] = Integer.parseInt(args[i]);

		int[] tree = new int[1000];
		buildSegmentTree(0, 0, arr.length - 1, arr, tree);

		int index = getMin(0, 0, arr.length - 1, 4, 5, arr, tree);
		System.out.println("min[" + index + "] = " + arr[index]);
	}


	public static int buildSegmentTree(int node, int x, int y, int[] arr, int[] tree)
	{
		if(x == y)
		{
			tree[node] = x;
			return x;
		}


		int minLeft = buildSegmentTree(2 * node + 1, x, (x + y) / 2, arr, tree);
		int minRight = buildSegmentTree(2 * node + 2, ((x + y) / 2) + 1, y, arr, tree);


		if(arr[minLeft] < arr[minRight])
			tree[node] = minLeft;
		else
			tree[node] = minRight;

		return tree[node];
	}


	public static int getMin(int node, int b, int e, int x, int y, int[] arr, int[] tree)
	{
		// elimitate off range node
		if(x > e || y < b)
			return -1;

		// take in range
		if(b >= x && e <= y)
			return tree[node];

		int leftNode = getMin(node * 2 + 1, b, (b + e) / 2, x, y, arr, tree);
		int rightNode = getMin((node * 2) + 2, ((b + e) / 2) + 1, e, x, y, arr, tree);

		if(leftNode == -1)
			return rightNode;

		if(rightNode == -1)
			return leftNode;

		return arr[leftNode] < arr[rightNode] ? leftNode : rightNode;
	}
}
