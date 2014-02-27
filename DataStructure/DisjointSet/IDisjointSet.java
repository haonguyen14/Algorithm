public interface IDisjointSet<T> {
	public T find(T item);
	public boolean union(T set1, T set2);
}
