public class LeftistHeap<T extends Comparable<T>> {
	/*
	 *	Simple Binary Tree Implementation
	 */
	private class Tree<T> {
		public T mData;

		public Tree<T> mLeft;
		public Tree<T> mRight;


		public Tree(T data) {
			this.mData = data;
		}

		
		public Tree(T data, Tree<T> left, Tree<T> right) {
			this.mData = data;
			this.mLeft = left;
			this.mRight = right;
		}
	}

	
	Tree<T> mTree;


	/*
	 *	Constructor
	 *	Construct leftist heap
	 */
	public LeftistHeap() {
		this.mTree = null;
	}


	/*
	 *	Constructor
	 *	Construct leftist heap from an array
	 *	Runtime: 
	 */
	public LeftistHeap(T[] input) {
		
	}


	/*
	 *	Merge two leftist heaps
	 *	Runtime: 
	 */
	 public void merge(LeftistHeap<T> heap) {

	 }


	/*
	 *	Insert a new node
	 *	Runtime:
	 */
	 public void insert(T data) {

	 }


	 /*
	  *	Remove min/max
	  *	Runtime:
	  */
	  public T remove() {

	  }


	  /*
	   *	Extract min/max
	   *	Runtime: O(1)
	   */
	   public T extract() {
		return this.mTree.mData;
	   }
}
