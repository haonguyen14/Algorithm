import java.util.Stack;


public InorderTraversal {
	
	/*
	 *	Recursive Version
	 */
	 public static void traverse(Tree<T> tree) {
		if(tree == null)
			return;

		travesrse(tree.mLeft);
		System.out.print(tree.mData + " ");
		traverse(tree.mRight);
	 }



	 /*
	  *	Iterative Version
	  */
	  public static void traverse(Tree<T> tree) {
		Stack<Tree<T>> stack = new Stack<Tree<T>>();

		Tree<T> current = tree;
		do {
			if(current != null) {
				stack.push(current);
				current = current.mLeft;
			} else {
				current = stack.pop(); // root
				System.out.println(current.mData + " ");
				current = current.mRight;
			}
		} while(!stack.empty());
	  }
}
