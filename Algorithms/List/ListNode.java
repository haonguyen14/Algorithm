class ListNode<T> {
	public T mData;
	public ListNode<T> mNext;

	public ListNode(T data) {
		this.mData = data;
	}

	public ListNode(T data, ListNode<T> next) {
		this.mData = data;
		this.mNext = next;
	}
}
