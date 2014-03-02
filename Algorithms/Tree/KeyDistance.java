public class KeyDistance {
	public static void main(String[] args) {
		Tree<Integer> root = new Tree<Integer>(1, null, null);
		Tree<Integer> left = new Tree<Integer>(2, new Tree<Integer>(4, null, null), new Tree<Integer>(5, null, null));
		Tree<Integer> right = new Tree<Integer>(3, 
							new Tree<Integer>(6, null, new Tree<Integer>(8, null, null)), 
							new Tree<Integer>(7, null, null));

		root.mLeft = left;
		root.mRight = right;

		System.out.println("LCA: " + LowestCommonAncestor.LCA(root, Integer.parseInt(args[0]), Integer.parseInt(args[1])).mData);
		System.out.println("Distance: " + dist(root, Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}


	public static <T extends Comparable<T>> int dist(Tree<T> root, T a, T b) {
		/* Find LCA */
		Tree<T> lca = LowestCommonAncestor.LCA(root, a, b);

		/* Dist(lca, a) */
		int lcaA = distFromRoot(lca, a); 

		/* Dist(lca, b) */
		int lcaB = distFromRoot(lca, b);


		return lcaA + lcaB;
	}


	private static <T extends Comparable<T>> int distFromRoot(Tree<T> root, T a) {
		/* Edge Condition */
		if(root == null)
			return -1;
		if(root.mData.compareTo(a) == 0)
			return 0;

		int left = distFromRoot(root.mLeft, a);
		int right = distFromRoot(root.mRight, a); 

		if (left == -1 && right == -1)
			return -1;
		else
			return (right < 0 ? left : right) + 1;
	}
}
