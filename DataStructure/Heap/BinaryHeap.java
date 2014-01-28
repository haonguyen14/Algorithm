import java.util.ArrayList;

public class BinaryHeap<T> implements Heap<T> {
	private ArrayList<T> mTree;

	public BinaryHeap() {
		this.mTree = new ArrayList<T>();
	}


	public BinaryHeap(T[] input) {
		this.mTree = new ArrayList<T>();
		for(int i = 0; i < input.length; i++)
			this.insert(input[i]);
	}


	public void insert(T data) {

	}

	
	public T remove() {

	}


	public T extract() {

	}
}
