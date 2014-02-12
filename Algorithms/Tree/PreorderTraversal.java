import java.util.Stack;


public class PreorderTraversal {
	
	/**
	 *	Recursive version
	 */
	public static void traverse(Tree<T> tree) {
		if(tree == null)
			return;

		System.out.print(tree.mData + " ");

		traverse(tree.mLeft);
		traverse(tree.mRight);
	}


	/**
	 *	Iterative Version
	 */
	public static void traverse(Tree<T> tree) {
		Stack<Tree<T>> stack = new Stack<Tree<T>>();

		Tree<T> current = tree;
		do {
			if(current != null) {
				System.out.print(current.mData + " ");
				if(current.mRight != null)
					stack.push(current.mRight);

				current = current.mLeft;
			} else {
				current = stack.pop();
			}
		} while(!stack.empty() && current != null);
	}
}
