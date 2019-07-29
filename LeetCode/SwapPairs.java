package Leetcode;
/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * @author AD
 *
 */
public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		ListNode p = dummy;
		while(p.next != null && p.next.next != null) {
			ListNode node1 = p.next;
			ListNode node2 = node1.next;
			ListNode next =node2.next;
			
			node2.next = node1;
			node1.next = next;
			p.next = node2;
			p = node1;
		}
		return dummy.next;
    }
}
