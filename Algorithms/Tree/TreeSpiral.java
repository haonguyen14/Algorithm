import java.util.*;


/**
 *	Spiral Tree Traversal
 */

public class TreeSpiral {
	public static void main(String[] args) {
		Tree<Integer> left = new Tree(2, new Tree(4, null, null), new Tree(5, null, null));
		Tree<Integer> right = new Tree(3, new Tree(6, null, null), new Tree(7, null, null));

		Tree<Integer> root = new Tree(1, left, right);

		traverse(root);
	}

	public static <T> void traverse(Tree<T> tree) {
		Stack<Tree<T>> thisLevel = new Stack<Tree<T>>();
		Stack<Tree<T>> nextLevel = new Stack<Tree<T>>();
		thisLevel.push(tree);

		int level = 1;
		while(!thisLevel.empty() || !nextLevel.empty()) {
			Tree<T> node = thisLevel.pop();

			/* Processing */
			System.out.print(node.mData + " ");

			
			/* Add Children */
			if(level % 2 == 0) {
				if(node.mLeft != null) {
					nextLevel.push(node.mLeft);
				}

				if(node.mRight != null) {
					nextLevel.push(node.mRight);
				}
			} else {
				if(node.mRight != null) {
					nextLevel.push(node.mRight);
				}

				if(node.mLeft != null) {
					nextLevel.push(node.mLeft);
				}
			}
			
			
			/* Down */
			if(thisLevel.empty()) {
				Stack<Tree<T>> temp = thisLevel;
				thisLevel = nextLevel;
				nextLevel = temp;

				level++;
			}
		}
	}
}
