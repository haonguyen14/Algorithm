import java.util.ArrayList;

public class BinaryHeap<T extends Comparable<T>> implements Heap<T> {
	private ArrayList<T> mTree;

	public BinaryHeap() {
		this.mTree = new ArrayList<T>();
	}


	public BinaryHeap(T[] input) {
		this.mTree = new ArrayList<T>();
		for(int i = 0; i < input.length; i++)
			this.mTree.add(input[i]);

		// Heapify
		for(int i = (input.length / 2) - 1; i >= 0; i--)
			perculateDown(i);
	}


	public void perculateDown(int index) {
		int curr = index;
		while(curr < this.mTree.size()) {
			int left = getLeft(curr);
			left = left >= mTree.size() ? curr : left;

			int right = getRight(curr);
			right = right >= mTree.size() ? curr : right;

			int min = curr;
			if(mTree.get(min).compareTo(mTree.get(left)) > 0)
				min = left;
			if(mTree.get(min).compareTo(mTree.get(right)) > 0)
				min = right;

			if(min == curr) {
			 	break;
			} else {
				swap(mTree, curr, min);
				curr = min;
			}
		}
	}


	public void insert(T data) {
		this.mTree.add(data);

		/* Heapify */
		int curr = this.mTree.size() - 1;
		while(curr >= 0) {
			int parent = getParent(curr);
			if(mTree.get(parent).compareTo(mTree.get(curr)) <= 0)
				break;

			swap(mTree, curr, parent);
			curr = parent;
		}
	}

	
	public T remove() {
		if(this.mTree.isEmpty())
			return null;


		T ret = this.mTree.get(0);
		this.mTree.set(0, mTree.get(mTree.size() - 1));
		this.mTree.remove(mTree.size() - 1);

		/* Heapify */
		int curr = 0;
		while(curr < this.mTree.size()) {
			int left = getLeft(curr);
			left = left >= mTree.size() ? curr : left;

			int right = getRight(curr);
			right = right >= mTree.size() ? curr : right;

			int min = curr;
			if(mTree.get(min).compareTo(mTree.get(left)) > 0)
				min = left;
			if(mTree.get(min).compareTo(mTree.get(right)) > 0)
				min = right;

			if(min == curr) {
			 	break;
			} else {
				swap(mTree, curr, min);
				curr = min;
			}
		}

		return ret;
	}


	public T extract() {
		return this.mTree.isEmpty() ? null : this.mTree.get(0);
	}


	/* Helper Functions */
	private static <T> void swap(ArrayList<T> arr, int a, int b) {
		T temp = arr.get(a);
		arr.set(a, arr.get(b));
		arr.set(b, temp);
	}


	private static int getParent(int child) {
		return (child - 1) / 2;
	}


	private static int getLeft(int parent) {
		return (2 * parent) + 1;
	}

	
	private static int getRight(int parent) {
		return (2 * parent) + 2;
	}
}
