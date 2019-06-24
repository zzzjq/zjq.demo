package zjq.test.leetcode.easy;

/**
 * leetcode 160. 相交链表
 * 
 * @author zhangjingqi
 * @date 2019年6月24日下午7:52:20
 *
 **/
public class GetIntersectionNode {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode a = headA;
		ListNode b = headB;
		while (a != b) {
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		return a;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
