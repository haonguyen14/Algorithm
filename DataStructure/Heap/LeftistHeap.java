public class LeftistHeap<T> implements Heap<T> {
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
	public LeftistHeap(T data) {
		this.mTree = new Tree<T>(data);
	}


	/*
	 *	Constructor
	 *	Construct leftist heap from an array
	 *	Runtime: 
	 */
	public LeftistHeap(T[] input) {
		this.mTree = new Tree<T>(t[0]);	
	}


	/*
	 *	Merge two leftist heaps
	 *	Runtime: 
	 */
	 public void merge(LeftistHeap<T> heap) {
		if(heap == null)
			return;

		/* Compare Two Root Node */
		if(this.mTree.mData.compareTo(heap.mData) < 0) {
			heap.merge(this.mRight);
			this.mRight = heap;
		} else {
			this.merge(heap.mRight);
			heap.mRight = this;
			this = heap;
		}

		/* Fix */
		int leftNullPath = (this.mLeft == null) ? -1 : this.mLeft.getNullPathLength();
		int rightNullPath = (this.mRight == null) ? -1 : this.mRight.getNullPathLength();

		if(leftNullPath < rightNullPath) {
			LeftistHeap<T> temp = this.mLeft;

			this.mLeft = this.mRight;
			this.mRight = temp;
		}
	 }


	/*
	 *	Insert a new node
	 *	Runtime:
	 */
	 public void insert(T data) {
		this.merge(new LeftistHeap(data));
	 }


	 /*
	  *	Remove min/max
	  *	Runtime:
	  */
	  public T remove() {
		T ret = this.mTree.mData;

		this.mLeft.merge(this.mRight);
		this = mLeft;

		return ret;
	  }


	  /*
	   *	Extract min/max
	   *	Runtime: O(1)
	   */
	   public T extract() {
		return this.mTree.mData;
	   }


	   private int getNullPathLength() {
		if(this.mLeft == null || this.mRight == null)
			return 0;
		else
			return ((this.mLeft.getNullPathLength() > this.mRight.getNullPathLength()) ?
				this.mRight.getNullPathLength() : this.mLeft.getNullPathLength()) + 1;
	   }
}
