public class IndexedBinarySearchTree<T extends Comparable<T>> implements IBinarySearchTree<T> {
	private IndexedBinarySearchTree<T> left;
	private IndexedBinarySearchTree<T> right;

	private int leftSize;
	public T data;


	public IndexedBinarySearchTree(T data) {
		this.data = data;
		this.leftSize = 0;

		this.left = null;
		this.right = null;
	}


	public IndexedBinarySearchTree(T data, IndexedBinarySearchTree<T> left, IndexedBinarySearchTree<T> right) {
		this.data = data;
		this.leftSize = 0;

		this.left = left;
		this.right = right;
	}


	public void insert(T item) {
		if(this.data.compareTo(item) < 0) {
			/* right */
			if(this.right == null) {
				this.right = new IndexedBinarySearchTree<T>(item);
				return;
			}

			this.right.insert(item);
		} else if(this.data.compareTo(item) > 0) {
			/* left */
			this.leftSize++;
			if(this.left == null) {
				this.left = new IndexedBinarySearchTree<T>(item);
				return;
			}

			this.left.insert(item);
		}
	}


	public T search(T item) {
		int compare = this.data.compareTo(item);

		if(compare < 0)
			/* right */
			return (this.right != null) ? this.right.search(item) : null;
		else if(compare > 0)
			/* left */
			return (this.left != null) ? this.left.search(item) : null;
		else
			return this.data;
	}


	public T search(int index) {
		if(index < 0)
			return null;

		if(index < this.leftSize) {
			if(this.left == null)
				return null;

			return this.left.search(index);
		} else if(index > this.leftSize) {
			if(this.right == null)
				return null;

			return this.right.search(index - this.leftSize - 1);
		} else {
			return this.data;
		}
	}
}
