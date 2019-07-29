package Leetcode;
/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @author AD
 *
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        ListNode first = head;
        while(first != null) {
        	count++;
        	first = first.next;
        }
        count -= n;
        first = dummy;
        while(count > 0) {
        	count--;
        	first = first.next;
        }
        if (first.next == null && first.next.next == null) {
        	first.next = null;
		}else {
			first.next = first.next.next;
		}
    	return dummy.next;
    }
    
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;
        for (int i = 0; i < n + 1; i++) {
			q = q.next;
		}
        while(q != null) {
        	q = q.next;
        	p = p.next;
        }
        if (p.next.next == null) {
			p.next = null;
		} else {
			p.next = p.next.next;
		}
    	return dummy.next;
    }
}
