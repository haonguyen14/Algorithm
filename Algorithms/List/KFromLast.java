/**
 *	Find The Kth Element From the Last
 */

public class KFromLast {
	/**
	 *	Runtime Complexity: O(N)
	 */
	public static int findK(ListNode<Integer> list, int k) {
		/* Setup */
		ListNode<Integer> first = list;
		ListNode<Integer> second = list;
		for(int i = 0; i < k && second != null; i++)
			second = second.mNext;

		/* If k passes the list's length */
		if(second == null)
			return -1;

		while(second.mNext != null) {
			first = first.mNext;
			second = second.mNext;
		}

		return first.mData;
	}
}
