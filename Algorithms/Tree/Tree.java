public class Tree<T> {
	public T mData;

	public Tree<T> mLeft;
	public Tree<T> mRight;


	public Tree(T data, Tree<T> left, Tree<T> right) {
		this.mData = data;
		this.mLeft = left;
		this.mRight = right;
	}
}
