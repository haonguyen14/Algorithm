public interface Heap<T extends Comparable<T>> {
	/*
	 *	Insert a new node
	 */
	public void insert(T data);


	/*
	 *	Remove min/max
	 */
	public T remove();


	/*
	 *	Extract min/max
	 */
	public T extract();
}
