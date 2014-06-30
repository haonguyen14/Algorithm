import java.util.LinkedList;

public class ReverseAlternateLevel {
	public static class Tree {
		public int value;

		public Tree left;
		public Tree right;

		public Tree(int v, Tree l, Tree r) {
			this.value = v;
			this.left = l;
			this.right = r;
		}
	}


	public static void reverse(Tree t) {
		LinkedList<Tree> list = new LinkedList<Tree>();
		
		int level = 0;
		int nodes = 0;
		list.add(t);

		/* BFS */
		while(!list.isEmpty()) {
			Tree node = list.removeFirst();
			if(node.left != null)
				list.add(node.left);
			if(node.right != null)
				list.add(node.right);
			
			/* Level Control */
			nodes++;
			if(nodes == Math.pow(2, level)) {
				nodes = 0;
				level++;
			}

			/* Processing */
			System.out.print(node.value + " ");
		}
	}


	public static void main(String[] args) {
		Tree t = new Tree( 1, 
			new Tree(2, new Tree(3, null, null), 
				    new Tree(4, null, null)),
			new Tree(5, new Tree(6, null, null), 
				    new Tree(7, null, null)) );

		reverse(t);
		System.out.println();
	}
}
