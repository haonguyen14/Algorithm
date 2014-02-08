public class LeftistHeap<T> implements Heap<T> {
	/*
	 *	Simple Binary Tree Implementation
	 */
	public T mData;

	public LeftistHeap<T> mLeft;
	public LeftistHeap<T> mRight;


	public LeftistHeap(T data) {
		this.mData = data;
	}

		
	public LeftistHeap(T data, LeftistHeap<T> left, LeftistHeap<T> right) {
		this.mData = data;
		this.mLeft = left;
		this.mRight = right;
	}
	


	/*
	 *	Constructor
	 *	Construct leftist heap
	 */
	public LeftistHeap(T data) {
		this.mData = data;
	}



	/*
	 *	Merge two leftist heaps
	 *	Runtime: 
	 */
	 public static <T extends Comparable<T>> LeftistHeap<T> merge(LeftistHeap<T> h1, LeftistHeap<T> h2) {
	 	LeftistHeap<T> newTree = null;
		LeftistHeap<T> h1Clone = h1 != null ? h1.clone() : null;
		LeftistHeap<T> h2Clone = h2 != null ? h2.clone() : null;

		/* Edge Condition */
		if(h1 == null || h2 == null)
			return h1 != null ? h1 : h2;
		
		/* Merge */
		if(h1.mData.compareTo(h2.mData) < 0) {
			newTree = h1;
			newTree.mRight = LeftistHeap.merge(newTree.mRight, h2)
		} else {
			newTree = h2;
			newTree.mRight = LeftistHeap.merge(newTree.mRight, h1)
		}

		
		/* Fix */
		if(newTree.mLeft.getNullPathLength() < newTree.mRight.getNullPathLength()) {
			LeftistTree<T> temp = newTree.mLeft;

			newTree.mLeft = newTree.mRight;
			newTree.mRight = temp;
		}

		return newTree;
	 }


	/*
	 *	Insert a new node
	 *	Runtime:
	 */
	 public void insert(T data) {
		this = LeftistTree.merge(new LeftistHeap(data), this);
	 }


	  /*
	   *	Extract min/max
	   *	Runtime: O(1)
	   */
	   public T extract() {
	   	T ret = this.mData;
		this = LeftistHeap.merge(this.mLeft, this.mRight);
		return ret;
	   }


	   private int getNullPathLength() {
		if(this.mLeft == null || this.mRight == null)
			return 0;
		else
			return ((this.mLeft.getNullPathLength() > this.mRight.getNullPathLength()) ?
				this.mRight.getNullPathLength() : this.mLeft.getNullPathLength()) + 1;
	   }


	   private <T extends Comparable<T>> LeftistHeap<T> clone() {
		LeftistHeap<T> left = this.mLeft != null ? this.mLeft.clone() : null;
		LeftistHeap<T> right = this.mRight != null ? this.mRight.clone() : null;

		return new LeftistHeap<T>(this.mData, left, right);
	   }
}
