
/**
 *	Reverse K elements in a list
 */
public class ReverseKElements {
	public static <T> ListNode<T> reverse(ListNode<T> list, int k) {
		ListNode<T> prev = null;
		ListNode<T> curr = list;

		/* Edge Condition */
		if(list == null || list.mNext == null)
			return list;

		/* Reverse the First K nodes */
		int i = 0;
		while(i++ < k && curr != null) {
			ListNode<T> temp = curr.mNext;

			curr.mNext = prev;
			prev = curr;
			curr = temp;
		}

		/* Reverse the Rest of the List & Merge*/
		list.mNext = reverse(curr, k);

		return prev;
	}
}
