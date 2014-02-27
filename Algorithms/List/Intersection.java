public class Intersection {
	public static void main(String[] args) {
		ListNode<Integer> node1 = new ListNode<Integer>(1);
		ListNode<Integer> node2 = new ListNode<Integer>(2);
		ListNode<Integer> node3 = new ListNode<Integer>(3);
		ListNode<Integer> node4 = new ListNode<Integer>(4);
		ListNode<Integer> node5 = new ListNode<Integer>(5);
		ListNode<Integer> node6 = new ListNode<Integer>(6);


		/* List 1 */
		node1.mNext = node2;
		node2.mNext = node3;
		node3.mNext = node4;

		/* List 2 */
		node5.mNext = node6;

		System.out.println("Intersection: " + (intersect(node1, node5) != null ? intersect(node1, node5) : "null") );
	}

	public static <T> ListNode<T> intersect(ListNode<T> l1, ListNode<T> l2) {
		/* Make Loop */
		ListNode<T> tail = l1;
		while(tail != null && tail.mNext != null)
			tail = tail.mNext;

		tail.mNext = l2;


		/* Find Knot */
		ListNode<T> slow = l1;
		ListNode<T> fast = l1;
		while(fast != null) {
			slow = slow.mNext;

			fast = fast.mNext;
			fast = fast != null ? fast.mNext : null;
			if(slow == fast) {
				break;
			}
		}

		
		/* Get Intersection */
		if(fast == null) {
			tail.mNext = null;
			return null;
		}


		slow = l1;
		while(slow != fast) {
			slow = slow.mNext;
			fast = fast.mNext;
		}

		/* Break Loop */
		tail.mNext = null;

		return fast;
	}
}
