package Leetcode;
/**
 * 删除链表中等于给定值 val 的所有节点。
 * @author AD
 *
 */
public class RemoveElement {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		while(head != null && head.val == val) {
			ListNode delNode = head;
			head = delNode.next;
			delNode.next = null;
		}
		if (head == null) {
			return null;
		}
		
		ListNode cur = head;
		while(cur.next != null) {
			if (cur.next.val == val) {
				ListNode delNode = cur.next;
				cur.next = delNode.next;
				delNode.next = null;
			}
		}
		return head;  
    }


	public ListNode removeElements2(ListNode head, int val) {
		ListNode header = new ListNode(-1);
		header.next = head;
		ListNode cur = header;
		while (cur.next != null) {
			if (cur.next.val == val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return header.next;
	}
}

