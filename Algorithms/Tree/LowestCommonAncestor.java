public class LowestCommonAncestor {
	public static void main(String[] args) {
		Tree<Integer> root = new Tree<Integer>(1, null, null);
		Tree<Integer> left = new Tree<Integer>(2, new Tree<Integer>(4, null, null), new Tree<Integer>(5, null, null));
		Tree<Integer> right = new Tree<Integer>(3, 
							new Tree<Integer>(6, null, new Tree<Integer>(8, null, null)), 
							new Tree<Integer>(7, null, null));

		root.mLeft = left;
		root.mRight = right;


		System.out.println("LCA: " + LCA(root, Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}


	/**
	 *	Assumption:	There is no duplicate node
	 *
	 */
	public static <T extends Comparable<T>> Tree<T> LCA(Tree<T> root, T a, T b) {
		/* Edge Condition */
		if(root == null)
			return null;
		if(root.mData.compareTo(a) == 0 || root.mData.compareTo(b) == 0)
			return root;

		
		Tree<T> left = LCA(root.mLeft, a, b);
		Tree<T> right = LCA(root.mRight, a, b);

		if(left != null && right != null)
			return root;
		else
			return (left != null) ? left : right;
	}
}
