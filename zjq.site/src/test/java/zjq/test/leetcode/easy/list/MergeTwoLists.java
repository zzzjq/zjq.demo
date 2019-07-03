package zjq.test.leetcode.easy.list;

/**
 * leetcode-21 合并两个有序链表
 * 
 * @author zhangjingqi
 * @date 2019年5月23日下午8:01:53
 *
 **/
public class MergeTwoLists {

	/** 递归 **/
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}

}
