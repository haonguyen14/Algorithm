import java.util.Stack;


public class InorderTraversal {
	
	public static void main(String[] args) {
		Tree<Integer> t = new Tree<Integer>( 1, 
			new Tree<Integer>(2, new Tree<Integer>(3, null, null), 
				    new Tree<Integer>(4, null, null)),
			new Tree<Integer>(5, new Tree<Integer>(6, null, null), 
				    new Tree<Integer>(7, null, null)) );
		
		Tree<Integer> t2 = new Tree<Integer>( 1, 
			null,	
			new Tree<Integer>(5, new Tree<Integer>(6, null, null), 
				    new Tree<Integer>(7, null, null)) );


		traverse(t2);
	}

	/*
	 *	Recursive Version
	 */
	 public static <T> void traverseRecur(Tree<T> tree) {
		if(tree == null)
			return;

		traverseRecur(tree.mLeft);
		System.out.print(tree.mData + " ");
		traverseRecur(tree.mRight);
	 }



	 /*
	  *	Iterative Version
	  */
	  public static <T> void traverse(Tree<T> tree) {
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
		} while(!stack.empty() || current != null);
	  }
}
